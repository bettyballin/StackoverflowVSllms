#include <stdio.h>

void my_strcpy(char *restrict dest, const char *restrict src) {
    while ((*dest++ = *src++) != '\0');
}

int main() {
    char src[] = "Hello, World!";
    char dest[20];
    my_strcpy(dest, src);
    printf("%s\n", dest);
    return 0;
}