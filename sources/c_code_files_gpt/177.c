#include <stdio.h>
#include <stdlib.h>

// Define the function pointer types
typedef void* (*MallocFunc)(size_t);
typedef void (*FreeFunc)(void*);

static MallocFunc g_mallocFunc = NULL;
static FreeFunc g_freeFunc = NULL;

void Initialize(MallocFunc mallocFunc, FreeFunc freeFunc) {
    g_mallocFunc = mallocFunc;
    g_freeFunc = freeFunc;
}

void* DllAllocateMemory(size_t size) {
    if (g_mallocFunc) {
        return g_mallocFunc(size);
    }
    return NULL;
}

void DllFreeMemory(void* ptr) {
    if (g_freeFunc) {
        g_freeFunc(ptr);
    }
}

int main() {
    // Initialize with standard malloc and free
    Initialize(malloc, free);

    // Allocate memory using the DLL functions
    void* ptr = DllAllocateMemory(10);
    if (ptr) {
        printf("Memory allocated successfully\n");
    } else {
        printf("Memory allocation failed\n");
    }

    // Free the allocated memory
    DllFreeMemory(ptr);

    return 0;
}