#define BSWAP_LOWER_32(T) { \\n    __asm__ __volatile__ ( \\n        "mov %%rax, %%rbx;"  /* Copy RAX to RBX */ \\n        "mov %%ebx, %%eax;"  /* Move lower 32 bits of RBX to EAX */ \\n        "bswap %%eax;"       /* Swap lower 32 bits in EAX */ \\n        "shl $32, %%rax;"    /* Shift swapped value to upper 32 bits */ \\n        "shr $32, %%rbx;"    /* Clear lower 32 bits of original value */ \\n        "or %%rbx, %%rax;"   /* Combine swapped lower 32 bits with upper 32 bits */ \\n        : "=a" (T)           /* Output */ \\n        : "a" (T)            /* Input */ \\n        : "rbx"              /* Clobbered register */ \\n    ); \\n}\n\nuint64_t val = 0x0123456789abcdef;\nBSWAP_LOWER_32(val);\n// Now val should contain 0x01234567efcdab89