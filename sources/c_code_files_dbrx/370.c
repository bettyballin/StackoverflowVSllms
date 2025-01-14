#include <stdlib.h>

// Static pointers for malloc & dealloc.
static void* (*Malloc)(size_t) = NULL;
static void (*Dealloc)(void*) = NULL;

void* CustomMalloc(size_t size) {
    return malloc(size);
}

void CustomFree(void *ptr) {
    free(ptr);
}

void Initialize(void (*mallocPtr)(size_t), void(*freePtr)(void*)) {
    Malloc = mallocPtr;
    Dealloc = freePtr;
}

int main() {
    // Example usage:
    Initialize(CustomMalloc, CustomFree);
    void* ptr = Malloc(10);
    // Use the allocated memory...
    Dealloc(ptr);
    return 0;
}