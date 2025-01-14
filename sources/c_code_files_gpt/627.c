#include <stdio.h>
#include <stdlib.h>

char* readFileIntoMemory(const char *filename, size_t *size) {
    FILE *file = fopen(filename, "rb");
    if (!file) {
        perror("Failed to open file");
        return NULL;
    }

    // Seek to the end of the file to determine its size
    fseek(file, 0, SEEK_END);
    *size = ftell(file);
    fseek(file, 0, SEEK_SET);

    // Allocate memory to hold the file contents
    char *buffer = (char *)malloc(*size + 1);
    if (!buffer) {
        perror("Failed to allocate memory");
        fclose(file);
        return NULL;
    }

    // Read the entire file into the buffer
    fread(buffer, 1, *size, file);
    buffer[*size] = '\0'; // Null-terminate the buffer

    fclose(file);
    return buffer;
}

int main() {
    size_t size;
    char *fileContents = readFileIntoMemory("example.txt", &size);
    if (fileContents) {
        printf("File contents:\n%s\n", fileContents);
        free(fileContents);
    }
    return 0;
}