#include <stdio.h>

long get_file_size(FILE *fp) {
    long fsize = 0;
    if(fseek (fp, 0, SEEK_END) == 0){ // Checking Error
        fsize = ftell (fp); // Getting current position which is the same as end-of-file
        rewind(fp); // Resetting file pointer back to beginning for further actions later in program.
    }
    return fsize;
}

int main() {
    FILE *fp = fopen("example.txt", "r"); // Open a file for reading.
    if (fp == NULL) {
        printf("Could not open file for reading.\n");
        return 1;
    }

    long fileSize = get_file_size(fp);
    printf("File size: %ld bytes\n", fileSize);

    fclose(fp); // Close the file.
    return 0;
}