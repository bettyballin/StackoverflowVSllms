#include <stdio.h>
#include <stdlib.h>
#include <stdarg.h>

void other_print(const char* data) {
    // Your special function implementation
    printf("Other Print: %s\n", data);
}

void my_printf(const char* format, ...) {
    va_list args;
    va_start(args, format);

    // First, print to stdout using vprintf
    vprintf(format, args);

    // Calculate the length of the formatted string
    va_list args_copy;
    va_copy(args_copy, args);
    int len = vsnprintf(NULL, 0, format, args_copy);
    va_end(args_copy);

    // Allocate memory for the formatted string
    char* buffer = (char*)malloc((len + 1) * sizeof(char));
    if (buffer == NULL) {
        // Handle memory allocation failure
        perror("malloc");
        va_end(args);
        return;
    }

    // Format the string into the buffer
    vsnprintf(buffer, len + 1, format, args);

    // Pass the formatted string to the other_print function
    other_print(buffer);

    // Free the allocated memory
    free(buffer);

    va_end(args);
}

int main() {
    my_printf("Hello, %s! Number: %d\n", "World", 42);
    return 0;
}