#include <stdint.h>

#define BSWAP_LOWER_32(T) { \
    __asm__ __volatile__ ( \
        "mov %%rax, %%rbx;"  /* Copy RAX to RBX */ \
        "mov %%ebx, %%eax;"  /* Move lower 32 bits of RBX to EAX */ \
        "bswap %%eax;"       /* Swap lower 32 bits in EAX */ \
        "shl $32, %%rax;"    /* Shift swapped value to upper 32 bits */ \
        "shr $32, %%rbx;"    /* Clear lower 32 bits of original value */ \
        "or %%rbx, %%rax;"   /* Combine swapped lower 32 bits with upper 32 bits */ \
        : "=a" (T)           /* Output */ \
        : "a" (T)            /* Input */ \
        : "rbx"              /* Clobbered register */ \
    ); \
}

int main() {
    uint64_t val = 0x0123456789abcdef;
    BSWAP_LOWER_32(val);
    // Now val should contain 0x01234567efcdab89
    return 0;
}