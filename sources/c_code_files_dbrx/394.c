#include <stdio.h>

// Define the original internal function
static void internal_function_original(void) {
    printf("Hello from internal_function_original!\n");
}

// Original internal_function (now a function pointer) pointing to its original implementation
static void (*internal_function)(void) = internal_function_original;

int main() {
    // Call the internal function through the function pointer
    internal_function();
    return 0;
}