#include <stdio.h>
#include <string.h>

#define BUFFER_SIZE 10 // Define the size of the buffer

int main() {
    char buffer[BUFFER_SIZE];
    char *input = "Hello, World!"; // Example input

    // Copy input into the buffer, ensuring null-termination
    strncpy(buffer, input, sizeof(buffer) - 1);
    buffer[sizeof(buffer) - 1] = '\0'; // Ensure null-termination

    printf("Buffer content: %s\n", buffer);

    return 0;
}