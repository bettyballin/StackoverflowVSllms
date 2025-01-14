#include <stdint.h>
#include <stdio.h>

int test(int x) {
    int y;
    union {
        uint32_t full;
        uint16_t half[2];
    } temp;

    temp.full = x;
    asm volatile ("rorw $8, %0" : "=r"(temp.half[0]) : "0"(temp.half[0]) : "cc");
    y = temp.full;

    return y;
}

int main() {
    int x = 0x12345678; // Example input
    int result = test(x);
    printf("Result: 0x%x\n", result);
    return 0;
}