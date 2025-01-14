#include <stdio.h>
#include <limits.h>
#include <math.h> // Added for fabs function

#define DELTA 1e-8

void printDoubleAndLong(double d, long i) {
    printf("%f (%ld)\n", d, i); // Added newline character
}

int main() {
    double d = 0; 
    long long_max = LONG_MAX;
    for (long l = 1; l <= long_max; l++) {
        d += 1.0;
        if ((d - (double)l > DELTA || (double)l - d > DELTA) && fabs(l - d) >= fabs((double)l - d)) { 
            printDoubleAndLong(d, l);
            break;
        }
    }
    return 0; // Added return statement
}