#include <stdint.h>

void disable_caches() {
    uint32_t reg;

    // Disable data cache
    asm volatile("mrc p15, 0, %0, c1, c0, 0" : "=r"(reg));
    reg &= ~(1 << 2);
    asm volatile("mcr p15, 0, %0, c1, c0, 0" :: "r"(reg));

    // Invalidate data cache
    asm volatile("mcr p15, 0, %0, c7, c6, 0" :: "r"(0));

    // Disable instruction cache
    asm volatile("mrc p15, 0, %0, c1, c0, 0" : "=r"(reg));
    reg &= ~(1 << 12);
    asm volatile("mcr p15, 0, %0, c1, c0, 0" :: "r"(reg));

    // Invalidate instruction cache
    asm volatile("mcr p15, 0, %0, c7, c5, 0" :: "r"(0));
}

int main() {
    disable_caches();
    return 0;
}