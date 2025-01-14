#include <stdio.h>
#include <time.h>

int main() {
    struct timespec start, end;

    clock_gettime(CLOCK_MONOTONIC, &start);

    /* Simulate time consuming task */
    usleep(450 * 1000); // 450 milliseconds delay

    clock_gettime(CLOCK_MONOTONIC, &end);

    long seconds = end.tv_sec - start.tv_sec;
    long nanoseconds = (long)(end.tv_nsec - start.tv_nsec) / 1000000L; // Convert to milliseconds

    printf("Elapsed time: %ld seconds and %ld milliseconds\n", seconds, nanoseconds);
    return 0;  // Add return statement
}