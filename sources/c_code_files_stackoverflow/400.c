#include <stdio.h>

int peasant_mult(int a, int b) {
    int p = 0;
    for (; a != 0; a /= 2, b *= 2) {
        p += (a & 1) * b;
    }
    return p;
}

int main() {
    int a = 5;
    int b = 6;
    printf("%d * %d = %d\n", a, b, peasant_mult(a, b));
    return 0;
}