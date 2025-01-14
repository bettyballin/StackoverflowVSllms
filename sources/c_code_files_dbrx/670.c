#include <stdio.h>
#include <stdlib.h>

int readIntFromBinaryFile(FILE *file) {
    int value;
    size_t size = sizeof(value);
    if (fread(&value, size, 1, file) != 1) {
        // handle error - consider using perror() function to print error description
        perror("Error reading from file");
        return 0;
    }
    return value;
}

int main() {
    // Specify the path to your binary file here
    const char *filePath = "path/to/your/binaryfile.bin";
    FILE *file = fopen(filePath, "rb"); // Open the file in binary read mode
    if (file == NULL) {
        perror("Error opening file");
        exit(EXIT_FAILURE);
    }

    int value = readIntFromBinaryFile(file);
    printf("Read value: %d\n", value);

    fclose(file); // Don't forget to close the file
    return 0;
}