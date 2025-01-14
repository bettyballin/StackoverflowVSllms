#include <stdio.h>

int main() {
    __asm__(".att_syntax prefix");
    __asm__("movl $0x1234,0xdeadbeef");

    __asm__(".att_syntax noprefix");
    __asm__("movl $0x1234,0xdeadbeef");

    // Parentheses are optional
    __asm__("movl $0x1234,(0xdeadbeef)");

    // Incorrect usage (will not compile)
    // __asm__("movl $0x1234,$0xdeadbeef"); // Error
    // __asm__("movl $0x1234,($0xdeadbeef)"); // Emits wrong code

    return 0;
}