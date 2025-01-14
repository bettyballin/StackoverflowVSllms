#include <dlfcn.h>
#include <stdio.h>

__attribute__((constructor))
void init() {
    void *handle = dlopen("/path/to/your/library.so", RTLD_LAZY);
    if (!handle) {
        fprintf(stderr, "%s\n", dlerror());
        return;
    }
    // Load your functions and start your watchdog here
}

int main() {
    // The init function will be called before main
    return 0;
}