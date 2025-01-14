#include <stdio.h>

int main() {
    char buff[10];
    const char *orig = "This string has more characters";
    snprintf(buff, sizeof(buff), "%s", orig); // buff is null-terminated now as snprintf always adds terminating null character.
    printf("%s\n", buff);
    return 0;
}