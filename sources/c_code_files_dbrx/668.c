#include <stdio.h>
#include <stdarg.h>
#include <stdlib.h>

void my_printf(const char *fmt, ...) {
    va_list args;   // List of variable arguments passed to the function
    char* data;  // Buffer for sprintf result

    // Initialize a varargs list (args is the reference point)
    va_start(args, fmt);

    // Call printf with our format string and additional arguments from va_list
    vprintf(fmt, args);

    // Calculate length of output required for sprintf, using vsnprintf function
    int len = vsnprintf(NULL, 0, fmt, args) + 1;   // Add one extra byte for the null terminator '\0'

    if (len <= 0) {
        va_end(args);                           // End vararg list processing and cleanup
        return;
    }

    data = malloc((size_t)len * sizeof(*data));   // Allocate space for sprintf output buffer

    if (!data) {
        va_end(args);       // If allocation error, clean up varargs and bail out (error handling omitted here)
        return;
    }

    // Since vsnprintf was already called, the internal pointer of va_list needs to be reset
    va_end(args);
    va_start(args, fmt);

    // Call vsprintf with our format string, additional arguments from va_list, and data buffer pointer. This fills the allocated string.
    vsnprintf(data, len, fmt, args);

    // Add your custom function processing printf result here (other_print)
    // For demonstration, we'll just print it again
    printf("Custom print: %s\n", data);

    free(data);         // Clean up allocated memory after use.

    va_end(args);       // End vararg list processing and cleanup
}

int main() {
    my_printf("Hello, %s!\n", "world");
    return 0;
}