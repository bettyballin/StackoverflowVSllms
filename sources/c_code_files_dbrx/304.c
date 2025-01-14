#include <stdio.h> // For printf
#include <time.h> // For clock_gettime()

int main () {
    struct timespec start, end;
    clockid_t clock = CLOCK_PROCESS_CPUTIME_ID;
    long duration;

    if((clock_gettime(clock, &start))) {
        printf("Error getting starting time\n");
        return -1;
    }

    /* your code to be measured here */

    if((clock_gettime(clock, &end))){
        printf("Error getting ending time...\n");
        return -1;
    }

    duration = (end.tv_sec * 1e9 + end.tv_nsec) - (start.tv_sec * 1e9 + start.tv_nsec);

    printf("Duration was %ld nanoseconds or %f microseconds\n", duration, ((float)duration / 1000));
    return 0;
}