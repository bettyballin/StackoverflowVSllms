#include <stdio.h>
#include <stdbool.h>

int main() {
    char c;
    printf("Enter a character: ");
    scanf(" %c", &c);

    bool is_hex_char = (c >= '0' && c <= '9') ||
                       (c >= 'a' && c <= 'f') ||
                       (c >= 'A' && c <= 'F');

    if (is_hex_char) {
        printf("%c is a hexadecimal character.\n", c);
    } else {
        printf("%c is not a hexadecimal character.\n", c);
    }

    return 0;
}