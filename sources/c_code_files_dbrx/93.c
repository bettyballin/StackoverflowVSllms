#include <stdio.h>

void safer_gets(char *str) {
    fgets(str, 256, stdin); /* assuming that str can contain upto 255 characters */
}

int main() {
    char input[256];
    printf("Enter a string: ");
    safer_gets(input);
    printf("You entered: %s", input);
    return 0;
}