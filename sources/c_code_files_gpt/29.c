#include <stdio.h>

int main() {
    int result;
    asm volatile (
        "movl $42, %%eax\n\t" // Move 42 into the EAX register
        "movl %%eax, %0\n\t"  // Move the value in EAX into the result variable
        : "=r" (result)       // Output list: result is an output
        :                     // Input list: no inputs
        : "%eax"              // Clobber list: EAX register is clobbered
    );
    return result;
}