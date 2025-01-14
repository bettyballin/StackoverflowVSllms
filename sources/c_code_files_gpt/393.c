#include <stdio.h>

int main() {
    // Before optimization
    int a = 2 + 3;

    // After constant folding
    int b = 5;

    printf("Before optimization: a = %d\n", a);
    printf("After constant folding: b = %d\n", b);

    return 0;
}