#include <stdio.h>

int main() {
    char uppercase = 'A'; // ASCII 65
    char lowercase = uppercase + 32; // ASCII 97, which is 'a'

    printf("Uppercase: %c\n", uppercase);
    printf("Lowercase: %c\n", lowercase);

    return 0;
}