#include <stdio.h>
#include <stdarg.h>

#define DEBUG 1 // Set it to 0 for normal execution or 1 for test mode/debugging purposes.

void myDebugPrint(const char* fmt, ...) {
    if (DEBUG) {
        va_list args;
        va_start(args, fmt);
        vfprintf(stdout, fmt, args);
        va_end(args);
    }
}

int main() {
    myDebugPrint("Hello, World!\n");
    return 0;
}