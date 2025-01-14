#include <sys/time.h>
#include <stdio.h>

void active_sleep(long microseconds) {
    struct timeval start, current;
    long elapsed_time;

    // Get the start time
    gettimeofday(&start, NULL);

    do {
        // Get the current time
        gettimeofday(&current, NULL);
        
        // Calculate elapsed time in microseconds
        elapsed_time = (current.tv_sec - start.tv_sec) * 1000000 + (current.tv_usec - start.tv_usec);

    } while (elapsed_time < microseconds);
}

void f1() {
    for (int i = 0; i < 1000; i++) {
        active_sleep(1000); // Sleep for 1000 microseconds
    }
}

int main() {
    f1();
    return 0;
}