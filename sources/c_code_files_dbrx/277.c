#include <stdio.h>
#include <stdlib.h>

int main(void) {
    int *arr = (int*)malloc(2000000 * sizeof(int));  // allocating memory for array with size of 8MB

    if (!arr) { /* Checking if null, could not allocate required memory */
        perror("Failed to allocate memory");
        return -1; // handle error or exit program
    }

    // Use allocated memory

    free(arr);  // Don't forget to free the memory when it is no longer needed!
    arr = NULL; // This will ensure you don't use freed pointer. Good practice.

    return 0;
}