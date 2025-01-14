#include <stdint.h>

int main() {
    uint8_t* pbyte = (uint8_t*)0x12345678; // Replace with a valid memory address or array
    uint32_t myInt = (*pbyte) | (*(pbyte + 1) << 8)  | (*(pbyte + 2) << 16) | (*(pbyte + 3) << 24);
    return 0;
}