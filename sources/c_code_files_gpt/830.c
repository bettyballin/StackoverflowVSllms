// libexample.c
#include <stdio.h>
#include <dlfcn.h>

// Declare the prototype of the main function we want to call
void main_function();

void library_function() {
    printf("Hello from library function!\n");

    // Lookup the main function symbol
    void (*main_function_ptr)() = dlsym(RTLD_DEFAULT, "main_function");
    if (main_function_ptr) {
        // Call the main function
        main_function_ptr();
    } else {
        fprintf(stderr, "Failed to find main_function: %s\n", dlerror());
    }
}

int main() {
    library_function();
    return 0;
}