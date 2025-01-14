#include <stdio.h>

int main() {
    int original = 0x12345678; // example value
    int mask = 0x0000FFFF; // example value
    int newbits = 0x87654321; // example value
    int result;

    result = (original & ~mask) | (newbits & mask);

    printf("Result: %x\n", result);

    return 0;
}