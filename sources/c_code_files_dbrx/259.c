#include <stdio.h>

int main() {
    __asm__ __volatile__ (
        "mov $0x4C00, %%ax\n"
        "int $0x21\n" // terminate program using standard DOS call
        :
        :
        : "ax"
    );
    return 0;
}