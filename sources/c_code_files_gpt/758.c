#include <stdio.h>

int main() {
    int a = 100;       // 4 bytes
    short b = 50;      // 2 bytes

    // Using int for operations
    int c = a + b;

    printf("Result: %d\n", c);

    return 0;
}