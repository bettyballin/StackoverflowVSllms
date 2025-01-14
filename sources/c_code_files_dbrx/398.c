#include <stdio.h>

// Necessary for some build environments when including python header files.
#define Py_LIMITED_API  

// Override default PyGetPrefix and PyGetPath
const char *(*customPy_GetPrefix)() = NULL;
void (*customPy_SetPrefix)(const char *) = NULL;
const char *(*customPy_GetPath)() = NULL;

const char* customPy_GetPrefix_impl() {
    // Implement your functionality here. For example:
    return "/path/to/use";  // Replace with the path you actually want to use.
}

void customPy_SetPrefix_impl(const char *newPath) {
    // Optional - might be needed if Python tries setting Py_GetPrefix after your initialization code has run.
    printf("Setting new prefix to: %s\n", newPath);
    // ... implementation...
}

int main() {
    // Assign the custom implementations
    customPy_GetPrefix = customPy_GetPrefix_impl;
    customPy_SetPrefix = customPy_SetPrefix_impl;

    // Example usage
    printf("Custom prefix: %s\n", customPy_GetPrefix());
    customPy_SetPrefix("/new/path");

    return 0;
}