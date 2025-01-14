#include <stdio.h>
#include <stdlib.h>

int main() {
    // Original pointer and its allocation
    void* oldptr = malloc(10); // Allocate 10 bytes initially
    if (oldptr == NULL) {
        printf("Memory allocation failed\n");
        return EXIT_FAILURE;
    }

    // New size for reallocation
    size_t newsize = 20;

    // Reallocation
    void* ptr = realloc(oldptr, newsize);
    if (ptr == NULL) {
        // Error handling: if realloc fails, the original pointer is still valid
        printf("Memory reallocation failed. Freeing original pointer.\n");
        free(oldptr);
        return EXIT_FAILURE;
    } else {
        oldptr = ptr; // Update the pointer
        printf("Memory reallocation successful.\n");
    }

    // Don't forget to free the allocated memory when you're done
    free(oldptr);

    return EXIT_SUCCESS;
}