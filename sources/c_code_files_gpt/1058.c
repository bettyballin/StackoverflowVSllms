#include <stdio.h>
#include <stdlib.h>

char* read_file_to_string(const char *filename) {
    FILE *file = fopen(filename, "r");
    if (!file) return NULL;

    fseek(file, 0, SEEK_END);
    long length = ftell(file);
    fseek(file, 0, SEEK_SET);

    char *content = malloc(length + 1);
    if (!content) {
        fclose(file);
        return NULL;
    }

    fread(content, 1, length, file);
    content[length] = '\0';

    fclose(file);
    return content;
}

int main() {
    const char *filename = "example.txt";
    char *content = read_file_to_string(filename);
    if (content) {
        printf("%s\n", content); // added newline character
        free(content);
    } else {
        printf("Failed to read file\n"); // added newline character
    }
    return 0;
}