#include <stdio.h>

// Define a struct to represent an RGB pixel
typedef struct {
    int r, g, b;
} RGBPixel;

int main() {
    // Define the RGB pixel value
    RGBPixel rgbpixel;
    rgbpixel.r = 255;
    rgbpixel.g = 0;
    rgbpixel.b = 0;

    // Define the 2D array to store RGB pixel values
    RGBPixel rgb[10][10];

    // Assign the RGB pixel value to the 2D array
    int i = 0, j = 0;
    rgb[i][j] = rgbpixel;

    // Print the assigned RGB pixel value
    printf("RGB pixel value at position (%d, %d): (%d, %d, %d)\n", i, j, rgb[i][j].r, rgb[i][j].g, rgb[i][j].b);

    return 0;
}