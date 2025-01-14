#include <stdio.h>

int main() {
    char buffer[100];
    sprintf(buffer, "This is a string with some %s and %d numbers", "strings", 42);
    printf("%s\n", buffer);
    return 0;
}