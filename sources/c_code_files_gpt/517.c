#include <stdio.h>

int main() {
    FILE *file = fopen("example.txt", "r");
    if (file == NULL) {
        perror("Failed to open file");
        return 1;
    }

    // Read until end of file
    while (fgetc(file) != EOF);

    // Check feof() before closing
    if (feof(file)) {
        printf("End of file reached.\n");
    }

    // Close the file
    fclose(file);

    // Undefined behavior: do not do this
    if (feof(file)) {
        printf("This is undefined behavior.\n");
    }

    return 0;
}