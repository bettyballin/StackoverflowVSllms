#include <stdio.h>
#include <stdlib.h>

int main() {
    const int old_size = 5;
    const int new_size = 10;
    int *array = calloc(old_size, sizeof(int));

    if (array != NULL && new_size > old_size) {
        // Resizing memory block:
        array = realloc(array, new_size * sizeof(int));
        if (array == NULL) {
            printf("Memory reallocation failed\n");
            return 1;
        }
    }

    // Don't forget to free the allocated memory
    free(array);

    return 0;
}