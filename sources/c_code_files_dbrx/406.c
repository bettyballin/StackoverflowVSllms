#include <stdio.h>

// Function to reverse bits of a given number i with n bits
unsigned int reverseBits(unsigned int i, unsigned int n) {
    unsigned int result = 0;
    for (unsigned int j = 0; j < n; ++j) {
        result = (result << 1) | (i & 1);
        i >>= 1;
    }
    return result;
}

int main() {
    int n = 3;
    for (unsigned int i = 0; i < (1 << n); ++i) {
        printf("%d -> %u\n", i, reverseBits(i, n));
    }
    return 0;
}