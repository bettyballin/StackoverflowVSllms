#include <stdio.h>

int main() {
    char buffer[10]; // declare a char array with a fixed size
    buffer[sizeof(buffer) - 1] = '\0'; // null-terminate the buffer
    printf("Buffer contents: %s\n", buffer);
    return 0;
}