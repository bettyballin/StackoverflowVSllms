#include <stdio.h>

// Define the type for the function pointer
typedef void (*func_ptr_t)(void);

// Function to register a function pointer with its name and signature
void REG_FUNCTION(func_ptr_t ptr, const char *name, const char *signature) {
    // Registration logic
    printf("Registering function pointer %p with name '%s' and signature '%s'\n", (void*)ptr, name, signature);
}

// Example function to be registered
void example_function() {
    printf("Example function called\n");
}

int main() {
    // Register the example function
    REG_FUNCTION(example_function, "example_function", "void example_function()");

    return 0;
}