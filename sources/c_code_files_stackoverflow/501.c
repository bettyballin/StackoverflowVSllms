#include <stdio.h>

int main() {
    long usec = 10000; // assign some value to usec
    while (usec >= 1000)
        usec /= 10;
    printf("%ld\n", usec); // print the result
    return 0;
}