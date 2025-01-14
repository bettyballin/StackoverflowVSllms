#include <stdio.h>

int main() {
    int sample = 10;  // Sample value
    int n = 1;        // Initial sample count
    float mean = 0.0; // Initial mean

    // The given code snippet
    mean = mean + (sample - mean) / (float)n;

    printf("Mean: %f\n", mean);

    return 0;
}