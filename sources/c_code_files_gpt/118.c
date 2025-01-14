#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>
#include <string.h>

short int* mallocStuff(long int number, short int base) {
    short int *array;
    int size = 1024;

    // Allocate memory with calloc, which will zero-initialize it
    array = (short int*)calloc(1, size * sizeof(short int));
    return array;
}

int main() {
    short int **translatedArray;

    // Allocate memory for an array of 4 short int pointers
    translatedArray = (short int**)malloc(4 * sizeof(short int*));

    for(int i = 0; i < 4; i++) {
        // Call mallocStuff which allocates 1024 bytes
        translatedArray[i] = mallocStuff(0, 0);

        if(i > 0) {
            // Print the difference in addresses
            printf("block size (for a): %p-%p : %li\n",
                (void*)translatedArray[i], (void*)translatedArray[i-1], (uintptr_t)translatedArray[i] - (uintptr_t)translatedArray[i-1]);
        }
    }

    // Free allocated memory
    for(int i = 0; i < 4; i++) {
        free(translatedArray[i]);
    }
    free(translatedArray);

    return 0;
}