#include <stdio.h>

// Declare the function foo with the pure attribute
int foo(int) __attribute__((pure));

// Define the function foo
int foo(int x) {
    // For demonstration, let's just return the square of x
    return x * x;
}

int main() {
    int num = 5;
    printf("The result of foo(%d) is: %d\n", num, foo(num));
    return 0;
}