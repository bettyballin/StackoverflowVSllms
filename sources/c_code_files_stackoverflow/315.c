#include <stdio.h>

float getJulianFromUnix(int unixSecs) {
    return (unixSecs / 86400.0) + 2440587.5;
}

int main() {
    int unixSecs = 1643723400; // Example Unix time
    float julianDate = getJulianFromUnix(unixSecs);
    printf("Julian date: %f\n", julianDate);
    return 0;
}