#include <stdio.h>
#include <stdlib.h>

void safer_function(size_t size) {
    // Allocate memory on the heap
    char *buffer = (char *)malloc(size);
    if (buffer == NULL) {
        fprintf(stderr, "malloc failed\n");
        return;
    }
    // Use the buffer
    for (size_t i = 0; i < size; ++i) {
        buffer[i] = 'A';
    }
    printf("Buffer filled with 'A's\n");

    // Free the allocated memory
    free(buffer);
}

int main() {
    // Safer heap allocation
    safer_function(1024 * 1024); // 1 MB allocation on heap
    return 0;
}