#include <stdint.h>

#define ARMV8_DC_CIVAC 0x1

static inline void invalidate_cache_line(void *addr) {
    asm volatile("dc civac, %0" : : "r" (addr) : "memory");
}

int main() {
    uint32_t data[8];

    // Example address to invalidate
    void *address_to_invalidate = &data[0];

    invalidate_cache_line(address_to_invalidate);

    // Further code to verify cache invalidation
    // ...

    return 0;
}