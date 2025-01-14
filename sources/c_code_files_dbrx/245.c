#include <stdio.h>
#include <dlfcn.h>

int main() {
    void (*func_ptr)(int); // Defines function pointer to handle func()
    void* libHandle = dlopen("path/to/sharedLib.so", RTLD_LAZY | RTLD_GLOBAL); // Load shared library

    if (dlerror()) { // Check for errors in loading
        printf("%s\n", dlerror());
    } else {
        *(void **) (&func_ptr) = dlsym(libHandle, "func"); // get symbol address of func() from the dynamic linker
        if (dlerror()) {
            printf("%s\n", dlerror());
        } else {
            (*func_ptr)(5); // use function pointer to call the target function in main app.
        }
    }

    // Don't forget to close the library handle
    if (libHandle) {
        dlclose(libHandle);
    }

    return 0;
}