#include <stdio.h>

void foo() {
    int x = 10;                     // automatic duration (local), block scope
    static int y = 5;               // static duration (persistent value across calls), block scope

    if (x > y) {
        auto int z = 32;            // explicit auto storage class, local to inner scope, not needed in this example as it defaults anyway.
        printf("z: %d\n", z);       /* This variable will be accessible only within the if block */
    }
}

int main() {
    foo();
    return 0;
}