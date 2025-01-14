#include <stdio.h>

int main() {
    // Writing to a file
    FILE *outFile = fopen("example.txt", "w");
    if (outFile != NULL) {
        fprintf(outFile, "Hello, World!\n");
        fprintf(outFile, "%d\n", 123);
        fclose(outFile);
    } else {
        perror("Unable to open file for writing");
    }

    // Reading from a file
    FILE *inFile = fopen("example.txt", "r");
    char line[256];
    if (inFile != NULL) {
        while (fgets(line, sizeof(line), inFile)) {
            printf("%s", line);
        }
        fclose(inFile);
    } else {
        perror("Unable to open file for reading");
    }

    return 0;
}