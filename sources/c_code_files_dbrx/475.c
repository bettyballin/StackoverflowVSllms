#include <stdio.h>

int main() {
    FILE *infile;
    errno_t err = fopen_s(&infile, ".\\Sample.jpg", "rb");
    if (err != 0) {
        printf("Error opening file\n");
        return 1;
    }
    // You may want to add code here to process the file
    fclose(infile);
    return 0;
}