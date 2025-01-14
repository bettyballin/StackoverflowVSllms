// main.c
#include <stdio.h>
#include <dlfcn.h>

void main_function() {
    printf("Hello from main function!\n");
}

int main() {
    void *handle;
    void (*library_function)();

    // Open the shared library
    handle = dlopen("./libexample.so", RTLD_LAZY);
    if (!handle) {
        fprintf(stderr, "%s\n", dlerror());
        return 1;
    }

    // Lookup the library function
    *(void **) (&library_function) = dlsym(handle, "library_function");
    if (!library_function) {
        fprintf(stderr, "%s\n", dlerror());
        dlclose(handle);
        return 1;
    }

    // Call the library function
    library_function();

    // Close the library
    dlclose(handle);
    return 0;
}