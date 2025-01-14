#include <stdio.h>
#include <stdlib.h>

// Define the function pointers for malloc and free
static void* (*dll_malloc)(size_t) = NULL;
static void (*dll_free)(void*) = NULL;

// Define the Initialize function
void Initialize(void* (*malloc_func)(size_t), void (*free_func)(void*)) {
    dll_malloc = malloc_func;
    dll_free = free_func;
}

// Define the DllAllocateMemory function
void* DllAllocateMemory(size_t size) {
    if (dll_malloc) {
        return dll_malloc(size);
    } else {
        return NULL;
    }
}

// Define the DllFreeMemory function
void DllFreeMemory(void* ptr) {
    if (dll_free) {
        dll_free(ptr);
    }
}

int main() {
    // Initialize DLL with standard malloc and free
    Initialize(malloc, free);

    // Allocate memory using DLL function
    void* ptr = DllAllocateMemory(100);
    if (ptr) {
        // Use the allocated memory
        printf("Memory allocated successfully\n");
        
        // Free the allocated memory
        DllFreeMemory(ptr);
    }

    return 0;
}