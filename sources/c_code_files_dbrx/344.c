#include <stdio.h>

int main() {
    #ifdef __SSE2__  // only when SSE2 supported by compiler and CPU
        printf("SSE2 is supported\n");
        // implement your loop with SSEx instructions here
        // ... your SSE2 code here ...
    #else           // fallback code for non-SSEx capable CPUs or compilers
        printf("SSE2 is not supported\n");
        // implement original code using bitwise AND, if-else etc.
        // ... your non-SSE2 code here ...
    #endif

    return 0;
}