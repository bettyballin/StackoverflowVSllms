#include <stdio.h>
#include <stdlib.h>

int main() {
    char *filename = "your_file.txt"; // replace with your file name
    char *buffer = 0;
    long length;
    FILE *f = fopen(filename, "rb");

    if (f) {
        fseek(f, 0, SEEK_END);
        length = ftell(f);
        fseek(f, 0, SEEK_SET);
        buffer = malloc(length);
        if (buffer) {
            fread(buffer, 1, length, f);
        }
        fclose(f);
    }

    if (buffer) {
        // start to process your data / extract strings here...
        printf("File content:\n%s\n", buffer);
        free(buffer); // don't forget to free the allocated memory
    }

    return 0;
}