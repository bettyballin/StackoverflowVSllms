#include <stdio.h>
#include <stdint.h>

// Windows API uses DWORD as unsigned long. For non-Windows platforms, we can define it as uint32_t for compatibility.
typedef uint32_t DWORD;

int main() {
    char *pInput = "Hello, World!";
    // Advance pInput by 4 characters (or any other offset based on the actual type and requirement)
    // and interpret the address as a pointer to DWORD.
    DWORD *ptr = (DWORD *)(pInput + 4);
    printf("Address of ptr: %p\n", (void*)ptr);
    // Note: Dereferencing 'ptr' might lead to undefined behavior or alignment issues depending on the actual data and system.
    return 0;
}