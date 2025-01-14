#include <stdio.h>

unsigned int reverseBits(unsigned int n) {
    unsigned int rev = 0;
    while (n > 0) {
        rev <<= 1;
        if (n & 1)
            rev ^= 1;
        n >>= 1;
    }
    return rev;
}

int main() {
    unsigned int n = 32; // example number, in binary it's : 0000 0000 0010 0000 (3rd index from right is set)
    printf("%u", reverseBits(n));
    return 0;
}