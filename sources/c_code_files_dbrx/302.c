#include <string.h>
#include <stdio.h>

void RemoveTrailingZeros(char* str) {
    int len = strlen(str);
    while (len > 0 && str[len-1] == '0') {
        len--;
    }
    if (len > 0 && str[len-1] == '.') { // Added a check for len > 0
        len--; // Remove the dot, too.
    }
    str[len] = '\0'; // Null terminate at removed last character position.
}

int main() {
    char str[] = "123.4500";
    printf("Original string: %s\n", str);
    RemoveTrailingZeros(str);
    printf("String after removing trailing zeros: %s\n", str);
    return 0;
}