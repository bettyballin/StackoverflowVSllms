#include <stdio.h>

// Placeholder function for "runalg". This needs to be replaced with the actual implementation.
int runalg(int i) {
    // Example implementation: just return the square of i
    return i * i;
}

int main() {
    int low = 1;         // Lower bound
    int high = 10;       // Upper bound
    int i;               // Loop counter
    int res;             // Result of runalg for each iteration
    int highestres = 0;  // Highest result found so far

    for (i = low; i <= high; ++i) {
        res = runalg(i);
        if (res > highestres) {
            highestres = res;
        }
    }

    printf("Highest result: %d\n", highestres);

    return 0;
}