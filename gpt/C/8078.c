inline unsigned char _bittestandset(unsigned long *a, unsigned long b)\n{\n    unsigned char result;\n    __asm__ volatile (\n        "bts %2, %1\n\t"\n        "setc %0"\n        : "=r" (result), "+m" (*a)\n        : "Ir" (b)\n        : "cc"\n    );\n    return result;\n}