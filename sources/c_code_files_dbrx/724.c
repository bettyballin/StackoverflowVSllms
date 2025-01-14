#include <stdio.h>
#include <string.h>

int main() {
    char buffer[5];

    strcpy(buffer, "HelloWorld"); // Overflow! Only 5 bytes were allocated but we're writing way more than that
}