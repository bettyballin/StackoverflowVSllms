#include <stdio.h>

int main() {
    FILE *fp;
    long sz;

    // Open a file in binary mode
    fp = fopen("example.txt", "rb");
    if (fp == NULL) {
        perror("Error opening file");
        return -1;
    }

    // Move the file pointer to the end of the file
    fseek(fp, 0L, SEEK_END);
    // Get the size of the file
    sz = ftell(fp);

    printf("File size: %ld bytes\n", sz);

    fclose(fp);
    return 0;
}