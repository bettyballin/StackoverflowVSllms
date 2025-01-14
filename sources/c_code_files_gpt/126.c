#include <stdio.h>

int main() {
    char c = 'A'; // Implementation-defined behavior
    signed char sc = -1; // Explicitly signed
    unsigned char uc = 255; // Explicitly unsigned

    printf("char: %d\n", c);
    printf("signed char: %d\n", sc);
    printf("unsigned char: %u\n", uc);

    return 0;
}