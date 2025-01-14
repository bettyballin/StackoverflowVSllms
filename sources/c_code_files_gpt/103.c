#include <stdio.h>
#include <stdlib.h>

int main() {
    int n = 10; // Define the value of n
    int i;
    for (i = 0; (i - 1) < n; i++) {
        char* b = (char*)malloc(12 * sizeof(char)); // Allocate sufficient memory
        if (b == NULL) {
            // Handle memory allocation failure
            fprintf(stderr, "Memory allocation failed\n");
            exit(1);
        }
        sprintf(b, "%d", i);
        // Use b as needed
        printf("%s\n", b); // Example usage
        free(b); // Free the allocated memory
    }
    return 0;
}