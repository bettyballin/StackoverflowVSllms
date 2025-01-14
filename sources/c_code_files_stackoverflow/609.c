#define _WIN32_WINNT 0x0600 // Define a Windows version, adjust as necessary
#define STRICT
#define _WIN32_IE 0x0600 // Define an IE version, adjust as necessary
#define NDEBUG // This is typically defined in release builds to disable assert
#undef _DEBUG // _DEBUG should not be defined for release builds
#define _SECURE_SCL 1 // Enable secure CRT

// Rest of your C code here...
#include <stdio.h>

int main() {
    printf("Hello, world!\n");
    return 0;
}