#include <stdio.h>

int main() {
    int i = 1; // Assign some value to i
    if (31 * i == (i << 5) - i) {
        printf("The expression is true for i = %d\n", i);
    } else {
        printf("The expression is false for i = %d\n", i);
    }
    return 0;
}