#include <sys/time.h>
#include <stdio.h>

int main(void) {
    struct timeval tv;
    long int ms;

    gettimeofday(&tv, NULL);
    ms = tv.tv_sec * 1000 + tv.tv_usec / 1000;	// Calculate milliseconds.

    printf("ms: %ld\n", ms); // Added newline character at the end of the format string
    return 0;
}