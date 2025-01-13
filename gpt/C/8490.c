#include <stdio.h>\n#include <stdlib.h>\n#include <string.h>\n#include <ctype.h>\n\n#define MAX_DIGITS 1000\n\n// Function to convert a character to its integer value\nint charToValue(char c) {\n    if (isdigit(c)) return c - '0';\n    if (isalpha(c)) return toupper(c) - 'A' + 10;\n    return -1; // Error case\n}\n\n// Function to convert a string in a given base to its binary representation\nchar* convertToBinary(const char* numStr, int base) {\n    int len = strlen(numStr);\n    char* binary = (char*)malloc(MAX_DIGITS * len + 1); // Allocate enough space\n    binary[0] = '\0'; // Initialize binary string\n\n    for (int i = 0; i < len; ++i) {\n        int value = charToValue(numStr[i]);\n        if (value < 0 || value >= base) {\n            free(binary);\n            return NULL; // Invalid character for the given base\n        }\n        \n        // Convert the value to binary and append it to the binary string\n        for (int j = (base == 16 ? 4 : (base == 8 ? 3 : (base == 2 ? 1 : 4))); j >= 0; --j) {\n            char bit = (value & (1 << j)) ? '1' : '0';\n            strncat(binary, &bit, 1);\n        }\n    }\n\n    return binary;\n}\n\nint main() {\n    const char* numStr = "F1E"; // Example hexadecimal number\n    int base = 16;\n    \n    char* binary = convertToBinary(numStr, base);\n    if (binary) {\n        printf("Binary: %s\n", binary);\n        free(binary);\n    } else {\n        printf("Invalid input or base!\n");\n    }\n    \n    return 0;\n}