#include <stdio.h>
#include <stdlib.h>

// Function to read data from a file
char *read_data(const char *fileName) {
    FILE *file = fopen(fileName, "r");
    if (!file) {
        printf("Error opening file: %s\n", fileName);
        return NULL;
    }

    // Get the file size
    fseek(file, 0, SEEK_END);
    long fileSize = ftell(file);
    rewind(file);

    // Allocate memory for the file data
    char *data = (char *)malloc(fileSize + 1);
    if (!data) {
        printf("Error allocating memory for file data\n");
        fclose(file);
        return NULL;
    }

    // Read the file data
    size_t bytesRead = fread(data, 1, fileSize, file);
    if (bytesRead != fileSize) {
        printf("Error reading file data\n");
        free(data);
        fclose(file);
        return NULL;
    }

    // Null-terminate the data
    data[fileSize] = '\0';

    fclose(file);
    return data;
}

int main() {
    const char *fileName = "example.txt"; // Replace with your file name
    char *data = read_data(fileName);

    if (data) {
        printf("File data: %s\n", data);
        free(data);
    }

    return 0;
}