#include <stdio.h>
#include <stdlib.h>

int main() {
    int size;
    printf("Enter the size of the array: ");
    if (scanf("%d", &size) != 1) {
        fprintf(stderr, "Failed to read the size of the array.\n");
        return 1;
    }

    if (size <= 0) {
        fprintf(stderr, "Array size must be a positive integer.\n");
        return 1;
    }

    // Allocate memory dynamically using calloc
    int *array = calloc(size, sizeof(int));
    if (array == NULL) {
        fprintf(stderr, "Memory allocation failed.\n");
        return 1;
    }

    // Initialize the array
    for (int i = 0; i < size; i++) {
        array[i] = i + 1;
    }

    // Print the array
    for (int i = 0; i < size; i++) {
        printf("%d ", array[i]);
    }
    printf("\n");

    // Free the allocated memory
    free(array);

    return 0;
}