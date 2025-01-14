#include <stdio.h>

#warning This is a compile-time warning message

#define STRINGIFY(x) #x
#define TOSTRING(x) STRINGIFY(x)
#define COMPILER_MESSAGE(msg) _Pragma(TOSTRING(message(msg)))

COMPILER_MESSAGE("This is a compile-time message")

int main() {
    printf("Hello, World!\n");
    return 0;
}