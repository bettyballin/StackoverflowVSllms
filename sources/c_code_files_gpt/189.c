#include <stdio.h>

unsigned int fsize(char* file) {
    FILE *fp = fopen(file, "rb"); // Open the file in binary mode
    if (fp == NULL) {
        return -1; // Return -1 on failure to open file
    }
    fseek(fp, 0, SEEK_END); // Move the file pointer to the end of the file
    unsigned int size = ftell(fp); // Get the current file pointer position, which is the size of the file
    fclose(fp); // Close the file
    return size;
}

int main() {
    char file[] = "example.txt"; // Replace with your file name
    unsigned int size = fsize(file);
    if (size == -1) {
        printf("Failed to open file %s\n", file);
    } else {
        printf("Size of file %s: %u bytes\n", file, size);
    }
    return 0;
}