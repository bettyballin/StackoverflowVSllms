#include <stdio.h>

int main() {
    int a = 10; // example value for a
    int b = 2;  // example value for b
    int p = 0;

    for (p = 0; p += (a & 1) * b, a != 1; a >>= 1, b <<= 1);

    printf("%d\n", p);

    return 0;
}