#ifdef _WIN32
    #endif
#include <stdio.h>

int check_debugger() {
    #ifdef _WIN32
    return IsDebuggerPresent();
    #else
    // Implement checks for other platforms
    return 0;
    #endif
}

int main() {
    if (check_debugger()) {
        printf("Debugger detected!\n");
        return 1;
    }

    // Rest of your code
    return 0;
}