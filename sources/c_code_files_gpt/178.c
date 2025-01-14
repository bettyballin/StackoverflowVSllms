#include <dlfcn.h>

int main() {
    void* handleA = dlopen("libA.so", RTLD_LAZY);
    void* handleB = dlopen("libB.so", RTLD_LAZY);

    if (!handleA || !handleB) {
        // handle error
        return 1;
    }

    // ... use the libraries ...

    // Unload DLL B
    dlclose(handleB);

    // Unload DLL A
    dlclose(handleA);

    return 0;
}