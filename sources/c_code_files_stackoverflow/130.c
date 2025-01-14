#include <stdio.h>
#include <stdlib.h>

int main() {
    int val = 10;  // Assign some value to val
    FILE *fp = fopen("output.txt", "w");  // Open a file in write mode

    if (fp == NULL) {
        printf("Could not open file\n");
        return 1;
    }

    fwrite((const void*)&val, sizeof(int), 1, fp);  // Write val to the file
    fclose(fp);  // Close the file

    return 0;
}