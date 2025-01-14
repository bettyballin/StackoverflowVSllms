#include <stdio.h>
#include <stdint.h>
#include <time.h>

#define MAX_TIMESTAMPS 100

// Simulate the get_timer function using the POSIX clock_gettime function
unsigned long get_timer(int timer_id) {
    struct timespec ts;
    clock_gettime(CLOCK_MONOTONIC, &ts);
    return (unsigned long)ts.tv_sec * 1000 + ts.tv_nsec / 1000000;
}

unsigned long timestamps[MAX_TIMESTAMPS];
int count = 0;

void log_timestamp(void) {
    if (count < MAX_TIMESTAMPS) {
        timestamps[count++] = get_timer(0);
    }
}

// Example usage
void some_boot_stage_function(void) {
    log_timestamp();
    // ... existing code ...
}

int main() {
    some_boot_stage_function();
    for (int i = 0; i < count; i++) {
        printf("Timestamp %d: %lu ms\n", i, timestamps[i]);
    }
    return 0;
}