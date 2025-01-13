#include <stdio.h>\n\n// Function to get the values of general purpose registers\nvoid dump_registers() {\n    unsigned int eax, ebx, ecx, edx;\n    unsigned int eflags;\n\n    // Inline assembly to get the register values\n    __asm__ __volatile__(\n        "mov %%eax, %0\n\t"\n        "mov %%ebx, %1\n\t"\n        "mov %%ecx, %2\n\t"\n        "mov %%edx, %3\n\t"\n        "pushf\n\t"\n        "pop %4\n\t"\n        : "=r" (eax), "=r" (ebx), "=r" (ecx), "=r" (edx), "=r" (eflags)\n    );\n\n    // Print the register values\n    printf("EAX=%08X EBX=%08X ECX=%08X EDX=%08X\n", eax, ebx, ecx, edx);\n\n    // Extract and print the condition flags from EFLAGS\n    printf("CF=%d SF=%d ZF=%d OF=%d\n",\n        (eflags >> 0) & 1,   // Carry Flag\n        (eflags >> 7) & 1,   // Sign Flag\n        (eflags >> 6) & 1,   // Zero Flag\n        (eflags >> 11) & 1   // Overflow Flag\n    );\n}\n\nint main() {\n    dump_registers();\n    return 0;\n}