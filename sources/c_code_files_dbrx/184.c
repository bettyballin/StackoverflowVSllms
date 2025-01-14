#include <stdint.h>
#include <stdio.h>

#define BSWAP_32(r32) ({ \
    uint32_t tmp = (uint32_t)(r32);\
    asm ( "bswap %0" : "+r" (tmp)); \
    tmp; \
  })

int main() {
    uint32_t original = 0x12345678;
    uint32_t swapped = BSWAP_32(original);
    
    printf("Original: 0x%x\n", original);
    printf("Swapped: 0x%x\n", swapped);
    
    return 0;
}