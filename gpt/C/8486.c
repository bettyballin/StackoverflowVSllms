#include <stdio.h>\n#include <stdlib.h>\n#include <time.h>\n\n// Function to swap two characters\nvoid swap(char *a, char *b) {\n    char temp = *a;\n    *a = *b;\n    *b = temp;\n}\n\n// Function to shuffle the string\nvoid fisherYatesShuffle(char *str, size_t n) {\n    if (n > 1) {\n        for (size_t i = n - 1; i > 0; i--) {\n            size_t j = rand() % (i + 1);\n            swap(&str[i], &str[j]);\n        }\n    }\n}\n\nint main() {\n    char str[] = "Your 80-character string here..."; // Replace with your actual string\n    size_t length = sizeof(str) - 1; // Length of the string excluding the null terminator\n\n    // Seed the random number generator\n    srand((unsigned int)time(NULL));\n\n    // Shuffle the string\n    fisherYatesShuffle(str, length);\n\n    // Print the shuffled string\n    printf("Shuffled string: %s\n", str);\n\n    return 0;\n}