#include <stdio.h>

int foo(int x) __attribute__((const));

int foo(int x) {
    // Example operation: simply return the input.
    return x;
}

int main() {
    int input = 5;
    printf("Result of foo(%d): %d\n", input, foo(input));
    return 0;
}