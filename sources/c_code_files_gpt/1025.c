#include <stdio.h>

int main() {
    printf("Before NOP instruction\n");
    
    __asm__ __volatile__ (
        ".byte 0x90\n\t"  // Insert a NOP instruction
    );
    
    printf("After NOP instruction\n");
    
    return 0;
}