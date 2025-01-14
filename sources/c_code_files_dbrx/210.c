#include <stdio.h>
#include <stdlib.h>

int main() {
    FILE *fp = NULL;
    
    // Open a file for writing. If it does not exist, it will be created.
    fp = fopen("example.txt", "w");
    if (fp == NULL) {
        perror("Failed to open file");
        exit(EXIT_FAILURE);
    }

    int n = fprintf(fp, "Hello World\n");
    if (n < 0) {
        perror("Failed to write to file");
        fclose(fp); // Close the file before exiting
        exit(EXIT_FAILURE);
    }

    fclose(fp); // Close the file after successful write
    return 0;
}