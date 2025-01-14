#include <stdio.h>
#include <sys/time.h>
#include <stdint.h>
#include <unistd.h>

typedef struct leaky_bucket {
    size_t capacity;      // Maximum burst size in bytes
    size_t tokens;        // Current number of tokens in bytes
    double rate;          // Token generation rate in bytes per millisecond
    uint64_t timestamp;   // Last timestamp in milliseconds
} leaky_bucket;

static uint64_t time_now() {
    struct timeval ts;
    gettimeofday(&ts, NULL);
    return (uint64_t)(ts.tv_sec * 1000 + ts.tv_usec / 1000);
}

static int leaky_bucket_init(leaky_bucket *lb, size_t max_burst, double rate) {
    lb->capacity = max_burst;
    lb->tokens = max_burst;
    lb->rate = rate;
    lb->timestamp = time_now();
    return 0;
}

static size_t leaky_bucket_consume(leaky_bucket *lb, size_t bytes) {
    uint64_t now = time_now();
    size_t elapsed_time = (size_t)(now - lb->timestamp);
    size_t new_tokens = (size_t)(lb->rate * elapsed_time);

    if (new_tokens > 0) {
        lb->tokens = (lb->tokens + new_tokens > lb->capacity) ? lb->capacity : lb->tokens + new_tokens;
        lb->timestamp = now;
    }

    if (bytes <= lb->tokens) {
        lb->tokens -= bytes;
        return 0;
    } else {
        return -1;
    }
}

// Placeholder implementation for read_msg
static size_t read_msg(void **msg, FILE *file) {
    char buffer[1024];
    size_t len = fread(buffer, 1, 1024, file);
    *msg = buffer;
    return len;
}

// Placeholder implementation for send_to_net
static void send_to_net(void *msg, size_t len) {
    printf("Sending %zu bytes to network...\n", len);
}

int main() {
    leaky_bucket lb;
    leaky_bucket_init(&lb, 125000, 900.0 / 8.0);  // 900 kbps to bytes per millisecond

    FILE *file = fopen("input.txt", "r");
    if (!file) {
        perror("fopen");
        return 1;
    }

    while (1) {
        void *msg;
        size_t len = read_msg(&msg, file);
        
        // Wait until enough tokens are available
        while (leaky_bucket_consume(&lb, len) != 0) {
            usleep(1000);  // Sleep for 1 millisecond
        }

        send_to_net(msg, len);

        if (feof(file)) {
            break;
        }
    }

    fclose(file);
    return 0;
}