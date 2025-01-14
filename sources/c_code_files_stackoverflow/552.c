#include <stdio.h>

int main() {
    int N = 10; // Assuming N is 10 for demonstration
    int X = 50; // Assuming X is 50 for demonstration
    int count[10] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; // Example values for count array
    int i, lower, upper;

    for (i = lower = 0; i < N * (X / 100); lower++) {
        i += count[lower];
        printf("i = %d, lower = %d\n", i, lower); // Added for visibility of the process
    }

    // Assuming the "other direction for upper" means reversing the operation or logic for upper
    int upperLimit = N * (X / 100);
    for (upper = N - 1; upper >= 0 && i >= 0; upper--) {
        i -= count[upper];
        printf("i = %d, upper = %d\n", i, upper); // Added for visibility of the process
    }

    return 0;
}