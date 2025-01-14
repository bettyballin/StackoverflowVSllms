#include <stdio.h>

void example_function() {
    int a = 10, b = 20, c;

    asm volatile (
        "addl %%ebx, %%eax;"
        : "=a" (c)
        : "a" (a), "b" (b)
        : "cc" // clobber flags
    );

    printf("%d\n", c); // print the result
}

int main() {
    example_function();
    return 0;
}