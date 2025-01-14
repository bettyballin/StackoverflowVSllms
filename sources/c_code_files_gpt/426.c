#include <stdio.h>

void cwritebinary_(char *filename, int *width, int *height, double *pixels)
{
    FILE *file;
    int imgSize = (*width) * (*height) * 3;
    int i;

    file = fopen(filename, "wb");
    if (file == NULL) {
        perror("Error opening file");
        return;
    }

    for (i = 0; i < imgSize; i++) {
        fwrite(&pixels[i], sizeof(double), 1, file);
    }

    fclose(file);
}

int main()
{
    char filename[] = "output.bin";
    int width = 10;
    int height = 10;
    double pixels[300];

    // Initialize pixels array with some values
    for (int i = 0; i < 300; i++) {
        pixels[i] = i;
    }

    cwritebinary_(filename, &width, &height, pixels);

    return 0;
}