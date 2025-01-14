#include <stdio.h>
#include <stdint.h> // for uintptr_t
#include <stdlib.h> // for malloc

int main() {
    // Initialize ptr to some memory location
    unsigned char* ptr = malloc(sizeof(double));

    // Check alignment
    if ((uintptr_t)ptr % sizeof(double) == 0) {
        double d = *((double*)ptr);
        // Proceed with using d
        printf("Pointer is aligned for double: %f\n", d);
    } else {
        // Handle misaligned pointer case
        fprintf(stderr, "Pointer is not aligned for double\n");
        // You might need to copy the data to a properly aligned location
    }

    free(ptr);
    return 0;
}