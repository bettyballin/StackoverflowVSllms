#include <stdio.h>

int main() {
    int a = 5; // Binary: 101
    int b = 3; // Binary: 011
    int c = a | b; // Results in int c being: 7 (Binary: 111)

    printf("a: %d (Binary: %03b)\n", a, a);
    printf("b: %d (Binary: %03b)\n", b, b);
    printf("c: %d (Binary: %03b)\n", c, c);

    return 0;
}