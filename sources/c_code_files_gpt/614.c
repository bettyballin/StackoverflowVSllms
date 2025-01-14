#include <stdio.h>
#include <string.h>

int main() {
    char buffer[20];
    memset(buffer, ' ', sizeof(buffer)); // Initialize buffer with spaces

    snprintf(buffer + 5, 10, "%s", "Hello"); // Write "Hello" starting at position 5

    // Print the buffer to see the result
    for (int i = 0; i < sizeof(buffer); i++) {
        putchar(buffer[i]);
    }
    putchar('\n'); // Fixed the missing closing quote

    return 0;
}