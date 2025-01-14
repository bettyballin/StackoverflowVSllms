#include <stdio.h>

#define STRINGIFY(x) #x
#define TOSTRING(x) STRINGIFY(x)
#define COMPILER_MESSAGE(msg) _Pragma(TOSTRING(message(msg)))

COMPILER_MESSAGE("This is a compile-time message")

int main() {
    return 0;
}