#include <stdint.h>
#include <stdio.h>

// Define the mask m
#define m ((uint32_t)1 << 31)

// Function to calculate the next state of the LFSR
uint32_t lfsr(uint32_t state) {
    unsigned bit;

    /* taps: 32 30 */
    // LSBs are numbered from right to left! So, that's tap "1" (bit 0) and tap "32" on the example.
    bit = ((state >> 0) ^ (state >> 2)) & 1;     /* taps: bits 0 and 2 XOR */
    return (state >> 1) ^ (((uint32_t)(-bit)) & m);    // The magic is in this line. If bit gets shifted off the end it should be returned to first position.
}

int main() {
    uint32_t initialState = 1; // Example initial state
    uint32_t nextState = lfsr(initialState);
    printf("Next state: 0x%x\n", nextState);
    return 0;
}