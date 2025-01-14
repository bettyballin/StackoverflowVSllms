#include <stdint.h>

int main() {
    uint8_t sixBitChar = 0x3F; // your input data (example value)
    uint8_t sevenBitChar;

    // append a zero as the LSB and store it in sevenBitChar
    sevenBitChar = (sixBitChar << 1);

    return 0;
}