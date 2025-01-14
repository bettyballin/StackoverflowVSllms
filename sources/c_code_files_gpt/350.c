#include <stdio.h>

int main() {
    #if defined(__i386__) || defined(_M_IX86) || !defined(__LP64__) && !defined(_LP64)
    printf("32-bit platform\n");
    #endif
    return 0;
}