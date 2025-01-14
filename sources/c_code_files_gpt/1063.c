#include <stdio.h>
#include <time.h>

void do_some_work() {
    // Simulate some work
    for (volatile int i = 0; i < 1000000; ++i);
}

int main() {
    struct timespec start, end;
    double elapsed;

    // Get the starting time
    clock_gettime(CLOCK_PROCESS_CPUTIME_ID, &start);

    // Call the function you want to time
    do_some_work();

    // Get the ending time
    clock_gettime(CLOCK_PROCESS_CPUTIME_ID, &end);

    // Calculate the elapsed time in microseconds
    elapsed = (end.tv_sec - start.tv_sec) * 1e6 + (end.tv_nsec - start.tv_nsec) / 1e3;

    printf("Elapsed time: %.3f microseconds\n", elapsed);

    return 0;
}