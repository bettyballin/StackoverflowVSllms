#include <stdio.h>

inline unsigned char _bittestandset(unsigned long *a, unsigned long b) {
    unsigned char result;
    __asm__ __volatile__ ( "btc %1, %2\n"
              "sbb %0,%0\n"
            : "=qm" (result), "+rm" (*a)
            : [b] "Iq"(b));
    return result;
}

int main() {
    unsigned long a = 0x12345678;
    unsigned long b = 3;
    unsigned char result = _bittestandset(&a, b);
    printf("Result: %u\n", result);
    return 0;
}