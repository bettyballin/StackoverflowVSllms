#include <stdio.h>

size_t fread(void *ptr, size_t size, size_t nmemb, FILE *stream) {
    // Implementation of fread function
    // Note: This function is already defined in the standard library, 
    // so you wouldn't normally define it yourself.

    // However, if you want to write a custom implementation, here's an example:
    size_t total_bytes = size * nmemb;
    size_t bytes_read = 0;

    while (bytes_read < total_bytes) {
        int c = fgetc(stream);
        if (c == EOF) break;

        ((char*)ptr)[bytes_read] = c;
        bytes_read++;
    }

    return bytes_read / size;
}

int main() {
    // Example usage of fread
    FILE *file = fopen("example.txt", "r");
    if (file == NULL) {
        printf("Could not open file\n");
        return 1;
    }

    char buffer[10];
    size_t bytes_read = fread(buffer, 1, 10, file);
    printf("Read %zu bytes: %s\n", bytes_read, buffer);

    fclose(file);
    return 0;
}