#include <stdio.h>
#include <limits.h>
#include <float.h>

#define DELTA 1e-8

int main() {
    double d;
    long i;

    for (i = 0L; i < LONG_MAX; i++) {
        d = (double)i;
        if (d != (double)((long)d)) {
            printf("First deviation at long: %ld\n", i);
            printf("Double value: %.0f\n", d);
            break;
        }
    }

    return 0;
}