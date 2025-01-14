#include <stdio.h>
#include <string.h>
#include <errno.h> // Include errno.h for errno_t type

int main() {
    char dest[10];
    const char *source = "Hello";

    // Using strcpy_s is not standard in GCC, use strncpy instead
    strncpy(dest, source, sizeof(dest));
    dest[sizeof(dest) - 1] = '\0'; // Ensure null-termination

    printf("Copied string: %s\n", dest);

    return 0;
}