#include <stdio.h>

// Type definition for a function pointer
typedef int (*func_ptr_t)(int, double);

// A function that matches the type definition
int example_function(int a, double b) {
    printf("Received int: %d and double: %f\n", a, b);
    return a;
}

int main() {
    // Create a function pointer
    func_ptr_t func_ptr = example_function;

    // Call the function through the pointer
    int result = func_ptr(10, 3.14);

    printf("Result from function call: %d\n", result);

    return 0;
}