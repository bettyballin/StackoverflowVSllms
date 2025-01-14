#include <stdio.h>
#include <stdint.h>

int main() {
    // Using .intel_syntax noprefix
    __asm__(".intel_syntax noprefix");
    __asm__("mov DWORD PTR ds:0xdeadbeef,0x1234");
    __asm__("mov DWORD PTR ds:[0xdeadbeef],0x1234");
    __asm__("mov DWORD PTR [0xdeadbeef],0x1234"); // Works, but warns

    // Switching to .intel_syntax prefix
    __asm__(".intel_syntax prefix");
    __asm__("mov DWORD PTR %ds:0xdeadbeef,0x1234");
    __asm__("mov DWORD PTR %ds:[0xdeadbeef],0x1234");
    __asm__("mov DWORD PTR [0xdeadbeef],0x1234"); // Works, but warns

    // This will still cause compilation issues due to syntax error
    // __asm__("mov DWORD PTR 0xdeadbeef,0x1234"); // Error

    return 0;
}