#include <stdlib.h>

int main() {
    // Allocate a resource with memory from CRT
    void* resource = malloc(1024); // Assign 1KB of heap space

    if (resource == NULL) {
        // Handle allocation failure
        return 1;
    }

    // Use the allocated resource...
    // ...

    // Then, deallocate with proper precautions:
    free(resource); // Return memory to CRT heap

    return 0;
}