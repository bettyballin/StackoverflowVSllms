#include <stdio.h>

int main() {
    asm volatile (
        "xorl %%eax, %%eax\n"
        "ret"
        :
        :
        : "eax"
    );
    return 0;
}