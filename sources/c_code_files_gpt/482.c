// Compile with: gcc -o main main.c -ldl

#include <stdio.h>
#include <dlfcn.h>

int main() {
    void *handle;
    int (*validate_license)(const char*);
    void (*critical_function)();

    // Load the shared library
    handle = dlopen("./liblicense_check.so", RTLD_LAZY);
    if (!handle) {
        fprintf(stderr, "Failed to load library: %s\n", dlerror());
        return 1;
    }

    // Get the function pointers
    validate_license = dlsym(handle, "validate_license");
    critical_function = dlsym(handle, "critical_function");

    if (!validate_license || !critical_function) {
        fprintf(stderr, "Failed to load functions: %s\n", dlerror());
        dlclose(handle);
        return 1;
    }

    // Check the license key
    const char* license_key = "VALID_LICENSE_KEY";
    if (validate_license(license_key)) {
        printf("License valid. Proceeding...\n");
        critical_function();
    } else {
        printf("Invalid license key. Exiting...\n");
    }

    // Close the library
    dlclose(handle);
    return 0;
}