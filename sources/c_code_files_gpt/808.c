#include <stdio.h>

// In module.c
static void module_specific_function() {
    // Function implementation
    printf("Module specific function called\n");
}

// This function is accessible outside the module
void public_function() {
    // Function implementation
    printf("Public function called\n");
    module_specific_function();
}

int main() {
    public_function();
    return 0;
}