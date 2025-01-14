#include <stdio.h>
#include <stdlib.h>

void* monitored_malloc(size_t size) {
    void* ptr = malloc(size);
    printf("Allocated %zu bytes at %p\n", size, ptr);
    return ptr;
}

void monitored_free(void* ptr) {
    printf("Freed memory at %p\n", ptr);
    free(ptr);
}

int main() {
    // Example usage
    int* arr = monitored_malloc(sizeof(int) * 10);
    monitored_free(arr);
    return 0;
}