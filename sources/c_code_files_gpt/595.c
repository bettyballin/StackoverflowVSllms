#include <stdint.h>
#include <stdio.h>

// Helper function to separate the bits of a number
uint32_t spreadBits(uint32_t x) {
    x = (x | (x << 16)) & 0x030000FF;
    x = (x | (x << 8))  & 0x0300F00F;
    x = (x | (x << 4))  & 0x030C30C3;
    x = (x | (x << 2))  & 0x09249249;
    return x;
}

// Function to compute the 3D Morton number
uint32_t morton3D(uint32_t x, uint32_t y, uint32_t z) {
    return (spreadBits(x) | (spreadBits(y) << 1) | (spreadBits(z) << 2));
}

int main() {
    uint32_t x = 512; // Example 10-bit number
    uint32_t y = 256; // Example 10-bit number
    uint32_t z = 128; // Example 10-bit number

    uint32_t mortonNumber = morton3D(x, y, z);
    printf("Morton Number: %u\n", mortonNumber);

    return 0;
}