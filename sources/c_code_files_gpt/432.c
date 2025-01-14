#include <stdio.h>

inline unsigned char _bittestandset(unsigned long *a, unsigned long b)
{
    unsigned char result;
    __asm__ volatile (
        "bts %2, %1\n\t"
        "setc %0"
        : "=r" (result), "+m" (*a)
        : "Ir" (b)
        : "cc"
    );
    return result;
}

int main() {
    unsigned long num = 0;
    unsigned long bit = 2;
    unsigned char result = _bittestandset(&num, bit);
    printf("Result: %u\n", result);
    return 0;
}