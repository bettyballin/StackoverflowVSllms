#include <stdio.h>
#include <stdlib.h>

// Assuming the following function is defined elsewhere in the codebase
int readIntFromBinaryFile(FILE *fp) {
    int value;
    fread(&value, sizeof(int), 1, fp);
    return value;
}

void openTest() {
    FILE *fp = fopen("dqmapt.mp", "rb"); // binary mode ("r") instead of text mode ("rt") for reading binary file
    if (fp) {
        int i = readIntFromBinaryFile(fp);
        int j = readIntFromBinaryFile(fp);
        fclose(fp);
        printf("%d\n", i);
        printf("%d\n", j);
    } else {
       // file opening error handling code here.
       printf("Error opening file.\n");
    }
}

int main() {
    openTest();
    return 0;
}