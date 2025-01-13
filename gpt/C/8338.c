#include <stdio.h>\n\nint main() {\n    unsigned char byte = 0b00010010; // Example byte: ???1?0??\n\n    // Define the bit positions (0-based index)\n    int bit1 = 2; // Position 2 (third bit)\n    int bit2 = 4; // Position 4 (fifth bit)\n\n    // Swap/toggle bits at positions bit1 and bit2\n    byte ^= (1 << bit1) | (1 << bit2);\n\n    // Print the result\n    printf("Resulting byte: %02X\n", byte); // Output should show the swapped/toggled byte\n\n    return 0;\n}