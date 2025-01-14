#include <stdio.h>
#include <stdio_ext.h>

void safer_gets(char *str) {
    __fsetlocking(stdin, FSETLOCKING_INTERNAL);
    fgets((char*)str, 256, stdin); /* assuming that str can contain upto 255 characters */
}

int main() {
    char input[256];
    printf("Enter a string: ");
    safer_gets(input);
    printf("You entered: %s", input);
    return 0;
}