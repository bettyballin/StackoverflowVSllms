#include <stdio.h>

int test (int x) {
    int y;
    // force compiler to pick a specific register
    asm("rorw   $8, %%dx"    
        : "=a"(y), "=d"(x));
    return y;
}

int main() {
    int x = 0x12345678;
    int result = test(x);
    printf("Result: 0x%x\n", result);
    return 0;
}