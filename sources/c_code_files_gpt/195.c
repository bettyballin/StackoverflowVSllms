#include <dlfcn.h>
#include <stdio.h>
#include <stdlib.h>

int main() {
    // Open the shared library
    void *handle = dlopen("plugin.so", RTLD_LAZY);
    if (!handle) {
        fprintf(stderr, "Error opening library: %s\n", dlerror());
        return EXIT_FAILURE;
    }

    // Get the symbol (function) from the shared library
    void (*plugin_function)() = dlsym(handle, "plugin_function");
    if (!plugin_function) {
        fprintf(stderr, "Error getting symbol: %s\n", dlerror());
        dlclose(handle);
        return EXIT_FAILURE;
    }

    // Call the function from the shared library
    plugin_function();

    // Close the shared library
    if (dlclose(handle) != 0) {
        fprintf(stderr, "Error closing library: %s\n", dlerror());
        return EXIT_FAILURE;
    }

    return EXIT_SUCCESS;
}