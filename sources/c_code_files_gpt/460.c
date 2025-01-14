#include <stdio.h>

// Define the dimensions of the image
#define IMGX 1024
#define IMGY 768

// Define the maximum value of a pixel color component
#define MAX_COLOR 255

int main() {
    // Initialize a 3D array to represent the image
    unsigned char img[IMGY][IMGX][3];

    // Initialize an array to store the frequency of each red color value
    int red_freq[MAX_COLOR + 1] = {0};

    int i, j;

    // Assuming the image data is already loaded into the img array
    for (j = 0; j < IMGX; j++) {
        for (i = 0; i < IMGY; i++) {
            red_freq[img[i][j][0]] += 1;
        }
    }

    return 0;
}