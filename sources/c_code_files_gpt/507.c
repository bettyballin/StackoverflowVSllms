#include "tlsf.h"
#include <stdlib.h>

// Define the memory pool size
#define POOL_SIZE (1024 * 1024) // 1 MB

int main() {
    // Create a memory pool
    void* pool = malloc(POOL_SIZE);
    if (!pool) {
        return -1; // Handle memory allocation failure
    }

    // Initialize TLSF with the memory pool
    tlsf_t tlsf = tlsf_create_with_pool(pool, POOL_SIZE);

    // Allocate memory using TLSF
    void* ptr = tlsf_malloc(tlsf, 64); // Allocate 64 bytes
    if (!ptr) {
        return -1; // Handle allocation failure
    }

    // Use the allocated memory...
    
    // Free the allocated memory
    tlsf_free(tlsf, ptr);

    // Destroy the TLSF allocator and free the memory pool
    tlsf_destroy(tlsf);
    free(pool);

    return 0;
}