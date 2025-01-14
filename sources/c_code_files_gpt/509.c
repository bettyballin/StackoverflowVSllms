#include <stdio.h>
#include <stdlib.h>

long getFileSize(FILE *file) {
    long size;
    fseek(file, 0, SEEK_END);  // Move the file pointer to the end of the file
    size = ftell(file);        // Get the current position of the file pointer (which is the size of the file)
    fseek(file, 0, SEEK_SET);  // Reset the file pointer to the beginning of the file
    return size;
}

int main() {
    const char *filename = "example.txt";
    FILE *file = fopen(filename, "rb");  // Open the file in binary mode
    if (file == NULL) {
        perror("Error opening file");
        return EXIT_FAILURE;
    }

    long fileSize = getFileSize(file);
    if (fileSize < 0) {
        perror("Error determining file size");
        fclose(file);
        return EXIT_FAILURE;
    }

    char *buffer = (char *)malloc(fileSize + 1);  // Allocate memory for the file content + null terminator
    if (buffer == NULL) {
        perror("Error allocating memory");
        fclose(file);
        return EXIT_FAILURE;
    }

    size_t bytesRead = fread(buffer, 1, fileSize, file);  // Read the file content into the buffer
    if (bytesRead != fileSize) {
        perror("Error reading file");
        free(buffer);
        fclose(file);
        return EXIT_FAILURE;
    }
    
    buffer[fileSize] = '\0';  // Null terminate the string

    // Use the buffer (file content)
    printf("File content:\n%s\n", buffer);

    free(buffer);  // Free the allocated memory
    fclose(file);  // Close the file

    return EXIT_SUCCESS;
}