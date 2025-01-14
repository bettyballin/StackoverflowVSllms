#include <stdio.h>
#include <stdlib.h>

int main() {
#if defined(__LP64__) || defined(_LP64)    // 64 bit platforms use 8 bytes for pointer
    char *ptr = malloc(10);
    printf("%p\n", ptr);                   // prints, e.g., 0x7fbd9d20ad53
#else                                     // 32-bit and others uses less than or equal to 4 bytes (e.g., pointer is 4 byte)
    char *ptr = malloc(10);
    printf("%p\n", ptr);                   // prints, e.g., 0x7fbd59aad668
#endif
    free(ptr); // Good practice to free allocated memory
    return 0;
}