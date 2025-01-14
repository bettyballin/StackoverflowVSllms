#include <stdio.h>

int main() {
    unsigned char byte = 0; // Initialize byte to 0

    byte = byte ^ (1 << 2); // Toggle bit 2
    byte = byte ^ (1 << 4); // Toggle bit 4

    printf("Byte value after toggling bits: %u\n", byte);

    return 0;
}