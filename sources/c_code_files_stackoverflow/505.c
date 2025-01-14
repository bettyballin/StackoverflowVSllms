#include <stdio.h>

int main() {
    unsigned int i = 0x12345678; // Example initial value for demonstration
    int n = 16; // Define and initialize 'n'

    i = (i & 0x55555555) << 1 | (i & 0xaaaaaaaa) >> 1;
    i = (i & 0x33333333) << 2 | (i & 0xcccccccc) >> 2;
    i = (i & 0x0f0f0f0f) << 4 | (i & 0xf0f0f0f0) >> 4;
    i = (i & 0x00ff00ff) << 8 | (i & 0xff00ff00) >> 8;
    i = (i & 0x0000ffff) << 16 | (i & 0xffff0000) >> 16;
    i >>= (32 - n);

    printf("Result: %08x\n", i); // Print the result in hexadecimal

    return 0;
}