#include <stdio.h>

int main() {
#if defined(__x86_64__) || defined(_M_X64) || defined(__LP64__) || defined(_LP64)
    printf("Running on a 64-bit platform\n");
#else
    printf("Running on a 32-bit platform\n");
#endif
    return 0;
}