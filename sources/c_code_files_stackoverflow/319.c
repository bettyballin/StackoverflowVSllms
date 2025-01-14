#include <stdio.h>

unsigned myBitOperation(unsigned x)
{
    return ((x<<1) | (x>>1)) & (~x);
}

int main() {
    unsigned x = 5; // Example input
    unsigned result = myBitOperation(x);
    printf("%u\n", result);
    return 0;
}