#include <stdio.h>
#include <dlfcn.h>

// This C function exists within a shared library
typedef int (*example_function)(int);

int main() {
    void *handle;
    example_function func;
    char *error;

    // Load dynamic library file from the specified filename
    handle = dlopen("/path/to/your/library.so", RTLD_LAZY);

    if(!handle)  {
        printf("Error: %s\n", dlerror());
        return -1;
    }

    // Load the symbol "example_func" from handle to a function pointer named 'func'
    func = (example_function)dlsym(handle, "example_func");

    if((error = dlerror()) != NULL)  {
        printf("Error: %s\n", error);
        return -1;
    }

    // Call the loaded function with argument 45 and print its output.
    int result = func(45);

    printf("Calling 'example_func()' returned: %d\n", result);

    dlclose(handle);
    return 0;
}