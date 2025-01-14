#include <stdlib.h>

int main() {
    // Declare a pointer to an array of pointers
    int** multi;

    // Allocate memory for the array of pointers
    multi = (int**)malloc(10 * sizeof(int*));

    // Initialize the pointers to NULL to avoid freeing unallocated memory
    for (int i = 0; i < 10; i++) {
        multi[i] = NULL;
    }

    // Allocate memory for individual arrays
    multi[5] = (int*)malloc(20 * sizeof(int));

    // Assign a value to an element in the allocated array
    multi[5][11] = 66;

    // Free the allocated memory in a safe manner
    for (int i = 0; i < 10; i++) {
        if (multi[i] != NULL) {
            free(multi[i]);
        }
    }

    // Free the array of pointers
    free(multi);

    return 0;
}