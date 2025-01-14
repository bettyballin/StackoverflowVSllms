#include <stdio.h>
#include <stdlib.h>

int main() {
    FILE *file = fopen("example.txt", "w");
    if (file) {
        fprintf(file, "Hello, World!\n");
        fclose(file);
    } else {
        perror("File opening failed");
        return EXIT_FAILURE;
    }
    return EXIT_SUCCESS;
}