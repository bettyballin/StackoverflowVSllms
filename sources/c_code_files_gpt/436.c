#include <stdio.h>
#include <string.h>

#define BUFFER_SIZE 256

void safeFunction(const char *input) {
    char buffer[BUFFER_SIZE];

    // Input validation
    if (input == NULL) {
        fprintf(stderr, "Invalid input\n");
        return;
    }

    // Safe copy with boundary checking
    strncpy(buffer, input, BUFFER_SIZE - 1);
    buffer[BUFFER_SIZE - 1] = '\0'; // Ensure null-termination

    printf("Processed input: %s\n", buffer);
}

int main() {
    const char *userInput = "This is a safe input.";
    safeFunction(userInput);
    return 0;
}