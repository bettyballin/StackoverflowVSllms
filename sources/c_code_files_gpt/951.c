#include <dlfcn.h>
#include <stdio.h>
#include <stdlib.h>

int main() {
    void* handle = dlopen("/path/to/library.dylib", RTLD_LAZY);
    if (!handle) {
        fprintf(stderr, "%s\n", dlerror());
        exit(EXIT_FAILURE);
    }

    void (*func)() = dlsym(handle, "function_name");
    if (!func) {
        fprintf(stderr, "%s\n", dlerror());
        exit(EXIT_FAILURE);
    }

    func();

    dlclose(handle);
    return 0;
}