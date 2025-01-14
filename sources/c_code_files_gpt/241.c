#include <stdio.h>
#include <stdlib.h>

size_t total_memory_allocated = 0;

void* my_malloc(size_t size) {
    void* ptr = malloc(size);
    if (ptr) {
        total_memory_allocated += size;
    }
    return ptr;
}

void my_free(void* ptr, size_t size) {
    free(ptr);
    total_memory_allocated -= size;
}

int main() {
    printf("Initial memory usage: %zu bytes\n", total_memory_allocated);
    void* ptr = my_malloc(1024); // Allocate 1024 bytes
    printf("Memory usage after allocation: %zu bytes\n", total_memory_allocated);
    my_free(ptr, 1024); // Free 1024 bytes
    printf("Memory usage after deallocation: %zu bytes\n", total_memory_allocated);

    return 0;
}