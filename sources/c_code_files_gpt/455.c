#include <stdint.h>

uint8_t next_schedule(uint8_t current, uint8_t mask) {
    uint8_t rotated = current;
    int bit_count = sizeof(rotated) * 8;  // Number of bits in the bit-string

    for (int i = 0; i < bit_count; i++) {
        rotated = (rotated << 1) | (rotated >> (bit_count - 1));  // Rotate left
        if (rotated & mask) {  // Check if rotated bit is in the mask
            return rotated & mask;  // Return the next scheduled bit
        }
    }

    return 0;  // Return 0 if no valid next schedule found
}