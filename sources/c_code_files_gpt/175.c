#include <stdint.h>
#include <stdio.h>

// 16-bit unsigned saturating addition
uint16_t sat_add16(uint16_t a, uint16_t b) {
    uint32_t sum = (uint32_t)a + (uint32_t)b;
    if (sum > 0xFFFF) {
        return 0xFFFF; // Saturate to 0xFFFF if overflow
    }
    return (uint16_t)sum;
}

// 32-bit unsigned saturating addition
uint32_t sat_add32(uint32_t a, uint32_t b) {
    uint64_t sum = (uint64_t)a + (uint64_t)b;
    if (sum > 0xFFFFFFFF) {
        return 0xFFFFFFFF; // Saturate to 0xFFFFFFFF if overflow
    }
    return (uint32_t)sum;
}

int main() {
    uint16_t a16 = 0xFF00, b16 = 0x0FFF;
    uint32_t a32 = 0xFFFFFF00, b32 = 0x00000FFF;

    printf("16-bit saturating addition: 0x%04X + 0x%04X = 0x%04X\n", a16, b16, sat_add16(a16, b16));
    printf("32-bit saturating addition: 0x%08X + 0x%08X = 0x%08X\n", a32, b32, sat_add32(a32, b32));

    return 0;
}