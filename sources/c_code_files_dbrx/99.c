#include <stdio.h>
#include <stdlib.h> // for exit function

#define BUFFER_SIZE 1024

void readFile(FILE* file) {
    char buffer[BUFFER_SIZE];
    if (!file) {
        perror("Error opening file");
        exit(-1);
    }

    while (fread(buffer, sizeof(char), BUFFER_SIZE, file)) {
        printf("%s", buffer);
    }
}

int main() {
    FILE* file = fopen("example.txt", "r"); // replace with your file name
    readFile(file);
    fclose(file);
    return 0;
}