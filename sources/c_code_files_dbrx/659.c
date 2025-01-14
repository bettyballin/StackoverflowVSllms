#include <stdio.h>

int main() {
    int var0 = 10;
    int var1 = 10;

    __asm__ __volatile__(
        "cmp %1,%2\n\t"
        "je extern_label\n\t"
        :
        : "a"(var0), "b"(var1)
        : "%ecx", "%edx", "cc"
    );

    printf("This will be skipped if var0 equals var1.\n");

    extern_label:
    printf("Continuing execution...\n");

    return 0;
}