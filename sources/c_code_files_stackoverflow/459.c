#include <stdio.h>

// Define the __stdcall calling convention for non-Windows platforms if necessary
#ifndef _WIN32
#define __stdcall
#endif

// Function prototype
void __stdcall Foo(int a, int b);

// Define the Foo function
void __stdcall Foo(int a, int b) {
    printf("Foo called with a = %d and b = %d\n", a, b);
}

int main() {
    // Example usage of Foo
    Foo(3, 5);
    return 0;
}