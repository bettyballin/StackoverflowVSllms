#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

#define MAX_DIGITS 1000

// Function to convert a character to its integer value
int charToValue(char c) {
    if (isdigit(c)) return c - '0';
    if (isalpha(c)) return toupper(c) - 'A' + 10;
    return -1; // Error case
}

// Function to convert a string in a given base to its binary representation
char* convertToBinary(const char* numStr, int base) {
    int len = strlen(numStr);
    char* binary = (char*)malloc(MAX_DIGITS * len + 1); // Allocate enough space
    binary[0] = '\0'; // Initialize binary string

    for (int i = 0; i < len; ++i) {
        int value = charToValue(numStr[i]);
        if (value < 0 || value >= base) {
            free(binary);
            return NULL; // Invalid character for the given base
        }
        
        // Convert the value to binary and append it to the binary string
        for (int j = (base == 16 ? 3 : (base == 8 ? 2 : (base == 2 ? 0 : 3))); j >= 0; --j) {
            char bit = (value & (1 << j)) ? '1' : '0';
            strncat(binary, &bit, 1);
        }
    }

    return binary;
}

int main() {
    const char* numStr = "F1E"; // Example hexadecimal number
    int base = 16;
    
    char* binary = convertToBinary(numStr, base);
    if (binary) {
        printf("Binary: %s\n", binary);
        free(binary);
    } else {
        printf("Invalid input or base!\n");
    }
    
    return 0;
}