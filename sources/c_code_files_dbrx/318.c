#include <stdio.h>

void foo (const char * str) {
    char buffer[64];

    snprintf(buffer, sizeof(buffer), "%s", str);
    printf("whoa: %s", buffer);
}

int main() {
    foo("Hello, World!");
    return 0;
}