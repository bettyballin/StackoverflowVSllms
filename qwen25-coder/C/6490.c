#include <stdio.h>\n#include <stdint.h>\n\nint main() {\n    uint32_t eax, ebx, ecx, edx;\n    uint32_t esi, edi, ebp, esp;\n    uint32_t eflags;\n\n    // Using inline assembly to get register values\n    __asm__ volatile(\n        "mov %%eax, %0\n"\n        "mov %%ebx, %1\n"\n        "mov %%ecx, %2\n"\n        "mov %%edx, %3\n"\n        "mov %%esi, %4\n"\n        "mov %%edi, %5\n"\n        "mov %%ebp, %6\n"\n        "lea (%%esp), %7\n" // LEA is used because direct move to ESP isn't allowed\n        : "=r"(eax), "=r"(ebx), "=r"(ecx), "=r"(edx),\n          "=r"(esi), "=r"(edi), "=r"(ebp), "=r"(esp)\n    );\n\n    __asm__ volatile (\n        "pushf\n"\n        "pop %0\n"\n        : "=r"(eflags)\n    );\n\n    // Printing the registers and flags\n    printf("EAX=%08X  EBX=%08X  ECX=%08X  EDX=%08X\n", eax, ebx, ecx, edx);\n    printf("ESI=%08X  EDI=%08X  EBP=%08X  ESP=%08X\n", esi, edi, ebp, esp);\n    printf("CF=%d  PF=%d  AF=%d  ZF=%d  SF=%d  TF=%d  IF=%d  DF=%d  OF=%d\n",\n            (eflags & (1<<0))?1:0,\n            (eflags & (1<<2))?1:0,\n            (eflags & (1<<4))?1:0,\n            (eflags & (1<<6))?1:0,\n            (eflags & (1<<7))?1:0,\n            (eflags & (1<<8))?1:0,\n            (eflags & (1<<9))?1:0,\n            (eflags & (1<<10))?1:0,\n            (eflags & (1<<11))?1:0\n    );\n\n    return 0;\n}