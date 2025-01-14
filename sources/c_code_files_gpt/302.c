#include <stdio.h>
#include <stdint.h>

uint16_t sat_add16(uint16_t a, uint16_t b) {
    uint16_t result = a + b;
    if (result < a) { // overflow
        return 0xFFFF;
    }
    return result;
}

uint32_t sat_add32(uint32_t a, uint32_t b) {
    uint32_t result = a + b;
    if (result < a) { // overflow
        return 0xFFFFFFFF;
    }
    return result;
}

int main() {
    uint16_t a16 = 0xFFFF;
    uint16_t b16 = 1;
    uint32_t a32 = 0xFFFFFFFF;
    uint32_t b32 = 1;

    uint16_t result16 = sat_add16(a16, b16);
    uint32_t result32 = sat_add32(a32, b32);

    printf("16-bit Saturating Addition: 0x%X\n", result16);
    printf("32-bit Saturating Addition: 0x%X\n", result32);

    return 0;
}