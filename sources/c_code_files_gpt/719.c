#include <gd.h>
#include <stdio.h>

int main() {
    // Create an image with width = 100 and height = 100
    gdImagePtr im = gdImageCreateTrueColor(100, 100);

    if (im == NULL) {
        fprintf(stderr, "Failed to create image\n");
        return 1;
    }

    // Define colors using RGB values within the range 0-255
    int red = 255; // Maximum value for red component
    int green = 0; // Minimum value for green component
    int blue = 0; // Minimum value for blue component

    // Resolve the color
    int color = gdImageColorResolve(im, red, green, blue);

    // Use the color to draw a filled rectangle
    gdImageFilledRectangle(im, 0, 0, 99, 99, color);

    // Save the image to a file
    FILE *out = fopen("output.png", "wb");
    if (out != NULL) {
        gdImagePng(im, out);
        fclose(out);
    } else {
        fprintf(stderr, "Failed to open output file\n");
    }

    // Destroy the image to free memory
    gdImageDestroy(im);

    return 0;
}