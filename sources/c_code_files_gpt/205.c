#include <stdio.h>
#include <stdlib.h>

int main() {
    int rows = 3;
    int cols = 4;
    int **m;

    // Allocate memory for the array of pointers (rows)
    m = (int **)malloc(rows * sizeof(int *));
    if (m == NULL) {
        perror("Failed to allocate memory");
        return EXIT_FAILURE;
    }

    // Allocate memory for each row (columns)
    for (int i = 0; i < rows; ++i) {
        m[i] = (int *)malloc(cols * sizeof(int));
        if (m[i] == NULL) {
            perror("Failed to allocate memory");
            return EXIT_FAILURE;
        }
    }

    // Assign a value to an element in the array
    m[1][2] = 12;

    // Print the assigned value
    printf("m[1][2] = %d\n", m[1][2]);

    // Free the allocated memory
    for (int i = 0; i < rows; ++i) {
        free(m[i]);
    }
    free(m);

    return 0;
}