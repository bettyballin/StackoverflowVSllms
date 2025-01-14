#include <stdio.h>

int main() {
    FILE *infile;
    errno_t err = fopen_s(&infile, ".\\Sample.jpg", "rb");
    if (err != 0) {
        printf("Error opening file");
        return 1;
    }
    // rest of your code here...
    fclose(infile);
    return 0;
}