#include <stdio.h>

int main() {
    int x = 1; // define x
    if (31 * x == (x << 5) - x) {
        printf("Expression is true for x = %d\n", x);
    } else {
        printf("Expression is false for x = %d\n", x);
    }
    return 0;
}