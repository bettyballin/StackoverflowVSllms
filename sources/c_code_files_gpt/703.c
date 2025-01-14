#include <stdio.h>

int main() {
    char c_str[100];
    snprintf(c_str, sizeof(c_str), "Hello, World!"); // Using C-style string functions
    printf("%s\n", c_str);
    return 0;
}