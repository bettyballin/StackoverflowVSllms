#include <stdio.h>

unsigned int fsize(const char* filename){
    FILE *fp = fopen(filename, "r");
    if (fp == NULL) {
        perror("Error opening file");
        return -1; // error handling the way you prefer
    }

    fseek(fp, 0L, SEEK_END);
    unsigned int sz = ftell(fp);
    fclose(fp);
    return sz;
}

int main() {
    const char* filename = "example.txt"; // replace with your file name
    unsigned int size = fsize(filename);
    if (size != -1) {
        printf("The size of %s is %u bytes.\n", filename, size);
    }
    return 0;
}