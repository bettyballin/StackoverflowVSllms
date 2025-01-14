#include <stdio.h>

int main() {
    FILE *fp = fopen("text.bin", "rb"); /* note the b; this is a compound mode */
    if (fp == NULL) {
        perror("Error opening file");
        return 1;
    }
    // You may want to add code here to read from the file
    fclose(fp);
    return 0;
}