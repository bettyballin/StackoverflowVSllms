#include <stdio.h>
#include <stdlib.h>

int main() {
    // Allocating a 1D array with capacity for 10 pointers to int arrays
    int **multi = (int **)calloc(10, sizeof(int *));

    for (int i = 0; i < 10; ++i) {
        // Allocate only if necessary, checking the pointer before usage and allocation.
        if (!multi[i]) {
            multi[i] = (int *)calloc((i + 1), sizeof(int));   // Arbitrary length based on index i for this example
        }
    }

    // Set a value within one of these arrays, e.g., at [5][11], assuming it is valid.
    // Note: This will cause undefined behavior because multi[5] is only allocated for 6 elements (index 0-5).
    //       Accessing index 11 is out of bounds. This should be fixed to access a valid index.
    // multi[5][11] = 66;

    // Fix: Set a value within the valid range of one of these arrays, e.g., at [5][4].
    multi[5][4] = 66;

    for (int i = 0; i < 10; ++i) {
        // Always check for null pointers before freeing memory
        if (multi[i]) {
            free(multi[i]);
            multi[i] = NULL;     // Best practice to set the pointer to NULL after freeing its allocation.
        }
    }

    // Freeing main array
    free(multi);

    return 0;
}