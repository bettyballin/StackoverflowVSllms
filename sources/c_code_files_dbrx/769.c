#include <stdio.h>
#include <stdlib.h>

int main() {
    int size = sizeof(short int);
    int number = 10; // Determine the length of the array

    short int* array = (short int*)calloc(number, size);

    if (array == NULL) {
        printf("Memory allocation failed\n");
        return -1;
    }

    // Use the allocated array
    for (int i = 0; i < number; i++) {
        array[i] = i;
    }

    // Don't forget to free the allocated memory
    free(array);

    return 0;
}