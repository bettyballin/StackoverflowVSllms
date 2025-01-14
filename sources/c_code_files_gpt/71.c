#include <stdio.h>

// Function to get the values of general purpose registers
void dump_registers() {
    unsigned int eax, ebx, ecx, edx;
    unsigned int eflags;

    // Inline assembly to get the register values
    __asm__ __volatile__(
        "mov %%eax, %0\n\t"
        "mov %%ebx, %1\n\t"
        "mov %%ecx, %2\n\t"
        "mov %%edx, %3\n\t"
        "pushf\n\t"
        "pop %4\n\t"
        : "=r" (eax), "=r" (ebx), "=r" (ecx), "=r" (edx), "=r" (eflags)
    );

    // Print the register values
    printf("EAX=%08X EBX=%08X ECX=%08X EDX=%08X\n", eax, ebx, ecx, edx);

    // Extract and print the condition flags from EFLAGS
    printf("CF=%d SF=%d ZF=%d OF=%d\n",
        (eflags >> 0) & 1,   // Carry Flag
        (eflags >> 7) & 1,   // Sign Flag
        (eflags >> 6) & 1,   // Zero Flag
        (eflags >> 11) & 1   // Overflow Flag
    );
}

int main() {
    dump_registers();
    return 0;
}