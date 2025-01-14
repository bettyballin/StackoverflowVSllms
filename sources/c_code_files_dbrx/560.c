#include <stdio.h>

int main() {
    FILE *infile;
    errno_t err = fopen_s(&infile, "Sample.jpg", "rb");
    if (err != 0) {
        printf("Error opening file: %d\n", err);
        return 1;
    }
    // You should also close the file when you're done with it
    fclose(infile);
    return 0;
}