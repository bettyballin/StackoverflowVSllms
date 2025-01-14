#include <stdint.h>
#include <stddef.h>

// Example: Locking instruction cache on ARM Cortex-M7
void lock_instruction_cache(void *start, size_t size) {
    uint32_t *addr = (uint32_t *)start;
    uint32_t *end = (uint32_t *)((uint8_t *)start + size);

    while (addr < end) {
        asm volatile("mcr p15, 0, %0, c7, c13, 1" :: "r"(addr));
        addr += 1; // Assuming 32-byte cache line size and 32-bit word size
    }
}

int main() {
    // Example usage:
    uint32_t cache_start = 0x00000000; // Replace with actual cache start address
    size_t cache_size = 0x1000; // Replace with actual cache size
    lock_instruction_cache((void *)cache_start, cache_size);
    return 0;
}