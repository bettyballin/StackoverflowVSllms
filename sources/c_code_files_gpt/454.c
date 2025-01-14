// opcode_functions.c

// We need to include the stdio header for printf
#include <stdio.h>

int add(int L, int R) {
    return L + R;
}

// You can add more functions for other opcodes.

// We need a main function as the entry point for the program
int main() {
    // Test the add function
    printf("%d + %d = %d\n", 2, 3, add(2, 3));
    return 0;
}