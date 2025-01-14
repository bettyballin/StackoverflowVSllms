#include <stdio.h>

int main() {
    unsigned int multiplicand = 0x1234; // The first 16-bit number
    unsigned int multiplier = 0x5678;   // The second 16-bit number
    unsigned int result = 0;         // The result of the multiplication

    while (multiplier != 0) {
        // Check if the least significant bit of the multiplier is set
        if (multiplier & 1) {
            result = result + multiplicand; // Add the current multiplicand to the result
        }
        multiplicand = multiplicand << 1;   // Shift the multiplicand left by 1 bit
        multiplier = multiplier >> 1;       // Shift the multiplier right by 1 bit
    }

    printf("The result of the multiplication is: 0x%x\n", result);

    return 0;
}