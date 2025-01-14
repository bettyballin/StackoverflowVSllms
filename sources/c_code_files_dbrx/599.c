#include <stdio.h>

#pragma GCC diagnostic push
#pragma GCC diagnostic ignored "-Wunused-variable"

int main() {
    // Example code that could trigger a specific compiler warning goes here
    int unusedVar; // This variable is declared but not used, which would normally trigger a warning.

    printf("Hello, world!\n");

    return 0;
}

#pragma GCC diagnostic pop