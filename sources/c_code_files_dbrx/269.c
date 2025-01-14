// Include necessary headers
#include <stdio.h>
#include <cpuid.h>
#include <immintrin.h> // for intrinsics like __readeflags()

int main() {
    unsigned long eax, ebx, ecx, edx;
    unsigned int flags = 0;

    // Use __get_flags macro to get EFLAGS register value
    #ifdef __SSE4A__ || (__OPTIMIZE__ && !defined(__APPLE__) && !defined(__linux__))
        asm volatile( "pushf; popl %0" : "=r" (flags));
    #elif defined _WIN32 || __CYGWIN__
        flags = __readeflags();
    #else // Fallback for unimplemented macro
        asm( "pushfl; popl %0" : "=r" (flags) );
    #endif

    printf("EFLAGS=%#x\n", flags);

    // Print status of individual flags to demonstrate getting flag values from EFLAGS register; modify accordingly for desired flags.
    if(flags & 0x1){
        printf("CF=1 ");
    }else{
        printf("CF=0 ");
    }

    if((flags >> 7) & 0x1){ // SF in the seventh bit
        printf("SF=1 ");
    } else {
        printf("SF=0 ");
    }

    if ((flags>>6)&0x1){// ZF in the sixth bit
        printf("ZF=1 ");
    }else{
        printf("ZF=0\n"); // Etc as needed
    }

    return 0;
}