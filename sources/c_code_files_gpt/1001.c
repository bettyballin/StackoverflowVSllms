#include <stdio.h>
#include <string.h>

int main() {
    char dest[256] = "Hello, ";
    char src[] = "World!";
    strncat(dest, src, sizeof(dest) - strlen(dest) - 1);
    printf("%s\n", dest);
    return 0;
}