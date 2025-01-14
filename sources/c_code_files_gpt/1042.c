#include <stdio.h>
#include <stdlib.h>

int main() {
    int *array = (int *)malloc(10 * sizeof(int));
    if (array == NULL) {
        fprintf(stderr, "Memory allocation failed\n");
        return 1;
    }

    // Initialize array
    for (int i = 0; i < 10; i++) {
        array[i] = 0;
    }

    // Your code logic here

    free(array);
    return 0;
}