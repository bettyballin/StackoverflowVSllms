#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {
    FILE *source;
    FILE *output;
    char buffer[4096];
    size_t bytesRead;

    memset(buffer, 0, sizeof(buffer));

    source = fopen("sourcefile.txt", "r");
    if (source == NULL) {
        perror("Error opening source file");
        return EXIT_FAILURE;
    }

    output = fopen("output.txt", "w");
    if (output == NULL) {
        perror("Error opening output file");
        fclose(source);
        return EXIT_FAILURE;
    }

    fprintf(output, "3, 1-3, 01/04/09\n");

    while ((bytesRead = fread(buffer, 1, sizeof(buffer), source)) > 0) {
        fwrite(buffer, 1, bytesRead, output);
    }

    fclose(source);
    fclose(output);

    if (remove("sourcefile.txt") != 0) {
        perror("Error deleting original file");
        return EXIT_FAILURE;
    }

    if (rename("output.txt", "sourcefile.txt") != 0) {
        perror("Error renaming file");
        return EXIT_FAILURE;
    }

    return EXIT_SUCCESS;
}