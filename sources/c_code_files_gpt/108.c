#include <stdio.h>
#include <stdlib.h>
#include <alloca.h>

void risky_function(size_t size) {
    // Allocate memory on the stack
    char *buffer = (char *)alloca(size);
    if (buffer == NULL) {
        fprintf(stderr, "alloca failed\n");
        return;
    }
    // Use the buffer
    for (size_t i = 0; i < size; ++i) {
        buffer[i] = 'A';
    }
    printf("Buffer filled with 'A's\n");

    // No need to free the buffer, it will be automatically deallocated
}

int main() {
    // Large allocation can cause stack overflow
    risky_function(1024 * 1024); // 1 MB allocation on stack
    return 0;
}