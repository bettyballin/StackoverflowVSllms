#include <stdio.h>
#include <stdlib.h>

void readFileUptoPosition(const char *filename, long position) {
    FILE *file = fopen(filename, "r");
    if (file == NULL) {
        perror("Error opening file");
        exit(EXIT_FAILURE);
    }

    char *buffer = (char *)malloc(position + 1); // Allocate memory for the buffer
    if (buffer == NULL) {
        perror("Error allocating memory");
        fclose(file);
        exit(EXIT_FAILURE);
    }

    size_t bytesRead = fread(buffer, 1, position, file);
    if (bytesRead < position) {
        if (feof(file)) {
            printf("Reached end of file.\n");
        } else {
            perror("Error reading file");
            free(buffer);
            fclose(file);
            exit(EXIT_FAILURE);
        }
    }

    buffer[bytesRead] = '\0'; // Null-terminate the string
    printf("Read content: %s\n", buffer);

    free(buffer);
    fclose(file);
}

int main(int argc, char *argv[]) {
    if (argc != 3) {
        fprintf(stderr, "Usage: %s <filename> <position>\n", argv[0]);
        exit(EXIT_FAILURE);
    }

    const char *filename = argv[1];
    long position = atol(argv[2]);

    readFileUptoPosition(filename, position);

    return 0;
}