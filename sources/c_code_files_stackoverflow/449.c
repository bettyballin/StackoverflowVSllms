#include <stdio.h>
#include <string.h>

int main() {
    char src[] = "Hello, World!";
    char dest[20];

    // strcpy -> strncpy
    strncpy(dest, src, 20);
    printf("strncpy: %s\n", dest);

    // strlen -> strnlen
    printf("strnlen: %lu\n", strnlen(src, 20));

    // strcmp -> strncmp
    printf("strncmp: %d\n", strncmp(src, "Hello", 5));

    // strcat -> strncat
    char dest2[20] = "Hello, ";
    strncat(dest2, "World!", 6);
    printf("strncat: %s\n", dest2);

    // strdup -> strndup
    char* dup = strndup(src, 13);
    printf("strndup: %s\n", dup);
    free(dup);

    // sprintf -> snprintf
    char buffer[20];
    snprintf(buffer, 20, "%s", src);
    printf("snprintf: %s\n", buffer);

    // wcscpy -> wcsncpy
    wchar_t wsrc[] = L"Hello, World!";
    wchar_t wdest[20];
    wcsncpy(wdest, wsrc, 20);
    printf("wcsncpy: %ls\n", wdest);

    // wcslen -> wcsnlen
    printf("wcsnlen: %lu\n", wcsnlen(wsrc, 20));

    return 0;
}