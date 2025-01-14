#include <stdio.h>
#include <ctype.h>

// Function to convert a string to uppercase
void upperCaseString(char *_str) {
    while (*_str) {
        *_str = toupper(*_str);
        _str++;
    }
}

int main() {
    char str[] = "Hello, World!";
    printf("Original string: %s\n", str);
    upperCaseString(str);
    printf("Uppercase string: %s\n", str);
    return 0;
}