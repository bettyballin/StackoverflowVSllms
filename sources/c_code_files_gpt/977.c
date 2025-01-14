#include <stdio.h>
#include <dlfcn.h>

int main() {
    // Load the shared library
    void *handle = dlopen("./libmodule.so", RTLD_LAZY);
    if (!handle) {
        fprintf(stderr, "%s\n", dlerror());
        return 1;
    }

    // Clear any existing error
    dlerror();

    // Get a pointer to the function `my_function`
    void (*my_function)() = (void (*)())dlsym(handle, "my_function");
    const char *dlsym_error = dlerror();
    if (dlsym_error) {
        fprintf(stderr, "%s\n", dlsym_error);
        dlclose(handle);
        return 1;
    }

    // Call the function
    my_function();

    // Close the shared library
    dlclose(handle);

    return 0;
}