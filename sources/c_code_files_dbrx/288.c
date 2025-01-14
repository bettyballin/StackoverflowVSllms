#include <stdio.h>

int main() {
    char buffer[10]; // Define the buffer with a size
    buffer[sizeof(buffer) - 1] = '\0'; // Correct the indexing to avoid buffer overflow
    printf("%s\n", buffer); // You might want to print or use the buffer
    return 0;
}