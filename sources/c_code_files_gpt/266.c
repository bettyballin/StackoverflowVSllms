#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <pthread.h>
#include <unistd.h>

#define BUFFER_SIZE 1024

typedef struct {
    char data[BUFFER_SIZE];
    int start;
    int end;
    pthread_mutex_t mutex;
    pthread_cond_t cond;
} circular_buffer;

circular_buffer stdout_buffer;
int stdout_pipe[2];

void init_buffer(circular_buffer *buffer) {
    buffer->start = 0;
    buffer->end = 0;
    pthread_mutex_init(&buffer->mutex, NULL);
    pthread_cond_init(&buffer->cond, NULL);
}

void write_buffer(circular_buffer *buffer, const char *data, size_t len) {
    pthread_mutex_lock(&buffer->mutex);
    for (size_t i = 0; i < len; ++i) {
        buffer->data[buffer->end] = data[i];
        buffer->end = (buffer->end + 1) % BUFFER_SIZE;
        if (buffer->end == buffer->start) {
            buffer->start = (buffer->start + 1) % BUFFER_SIZE;  // Overwrite oldest data
        }
    }
    pthread_cond_signal(&buffer->cond);
    pthread_mutex_unlock(&buffer->mutex);
}

void *writer_thread(void *arg) {
    char buffer[BUFFER_SIZE];
    while (1) {
        pthread_mutex_lock(&stdout_buffer.mutex);
        while (stdout_buffer.start == stdout_buffer.end) {
            pthread_cond_wait(&stdout_buffer.cond, &stdout_buffer.mutex);
        }
        size_t len = 0;
        while (stdout_buffer.start != stdout_buffer.end && len < BUFFER_SIZE) {
            buffer[len++] = stdout_buffer.data[stdout_buffer.start];
            stdout_buffer.start = (stdout_buffer.start + 1) % BUFFER_SIZE;
        }
        pthread_mutex_unlock(&stdout_buffer.mutex);
        if (len > 0) {
            write(STDOUT_FILENO, buffer, len);
        }
    }
    return NULL;
}

void setup_stdout_buffer() {
    init_buffer(&stdout_buffer);
    pipe(stdout_pipe);
    dup2(stdout_pipe[1], STDOUT_FILENO);
    close(stdout_pipe[1]);
    pthread_t thread;
    pthread_create(&thread, NULL, writer_thread, NULL);
}

ssize_t custom_write(int fd, const void *buf, size_t count) {
    if (fd == STDOUT_FILENO) {
        write_buffer(&stdout_buffer, buf, count);
        return count;
    }
    return write(fd, buf, count);
}

int main() {
    setup_stdout_buffer();

    // Redirect printf to use custom write
    printf("Hello, world!\n");
    fprintf(stdout, "This goes to stdout\n");

    // Simulate work
    sleep(1);

    pthread_exit(NULL); // Add this to ensure the writer thread exits
    return 0;
}