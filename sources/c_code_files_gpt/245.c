#include <stdio.h>
#include <string.h>

void foo (const char * str) {
     char buffer[64];

     strncpy(buffer, str, sizeof(buffer) - 1);
     buffer[sizeof(buffer) - 1] = '\0';

     printf("whoa: %s", buffer);
}

int main() {
    foo("Hello, World!");
    return 0;
}