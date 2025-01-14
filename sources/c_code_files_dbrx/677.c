#include <stdio.h>

int main() {
    __asm__ __volatile__(
        "nop;" // Example assembly code, replace with your own
        :
        : // Input operands go here, if any
        : // Clobbered registers go here, e.g., "memory", "cc"
    );

    printf("This is some C code.\n");

    goto extern_label;

    // Some other C code that will be skipped due to goto
    printf("This will be skipped.\n");

extern_label:
    printf("Continuing from extern_label...\n");

    return 0;
}