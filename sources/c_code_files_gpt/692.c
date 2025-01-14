#include <stdio.h>

int main() {
    unsigned char byte = 0b00010010; // Example byte: ???1?0??

    // Define the bit positions (0-based index)
    int bit1 = 2; // Position 2 (third bit)
    int bit2 = 4; // Position 4 (fifth bit)

    // Swap/toggle bits at positions bit1 and bit2
    byte ^= (1 << bit1) | (1 << bit2);

    // Print the result
    printf("Resulting byte: %02X\n", byte); // Output should show the swapped/toggled byte

    return 0;
}