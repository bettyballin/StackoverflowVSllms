#include <stdio.h>
#include <stdint.h>

// Define the missing functions ( normally provided by the Linux kernel )
int64_t div_s64(int64_t num, int64_t den) {
    return num / den;
}

uint64_t sqrt_64(uint64_t num) {
    // Simple integer square root implementation
    uint64_t x = num;
    uint64_t y = (x + 1) / 2;
    while (y < x) {
        x = y;
        y = (x + num / x) / 2;
    }
    return x;
}

int main() {
    int64_t num = 100;
    int64_t den = 3;
    uint64_t nr = 123456789;

    #ifdef CONFIG_MATH64
        // Use 64 bit division function from linux kernel.
        uint64_t result = div_s64(num, den);
        printf("Result: %llu\n", result);

        // Use 64 bit square root function from linux kernel.
        unsigned long res = sqrt_64(nr);
        printf("Square root: %lu\n", res);
    #else
        printf("CONFIG_MATH64 not defined\n");
    #endif

    return 0;
}