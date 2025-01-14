#include <stdio.h>

int main() {
    FILE *file = fopen("example.txt", "w");
    if (file == NULL) {
        perror("Error opening file");
        return 1;
    }

    int result = fprintf(file, "Hello, World!\n");
    if (result < 0) {
        perror("Error writing to file");
        fclose(file);
        return 1;
    }

    // Flush the output buffer to ensure the data is written to the file
    fflush(file);

    // Close the file to release resources
    fclose(file);

    return 0;
}