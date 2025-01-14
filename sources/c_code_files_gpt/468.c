#include <stdio.h>

// Define the dimensions of the image
#define IMGY 100
#define IMGX 100

// Define the maximum value of a pixel
#define MAX_PIXEL_VALUE 255

int main() {
    // Declare the 3D array to represent the image
    unsigned char img[IMGY][IMGX][3];

    // Declare the array to store the frequency of red pixel values
    int red_freq[MAX_PIXEL_VALUE + 1] = {0};

    // Initialize the image with some values (for demonstration purposes)
    for (int i = 0; i < IMGY; i++) {
        for (int j = 0; j < IMGX; j++) {
            img[i][j][0] = i % (MAX_PIXEL_VALUE + 1); // Red
            img[i][j][1] = j % (MAX_PIXEL_VALUE + 1); // Green
            img[i][j][2] = (i + j) % (MAX_PIXEL_VALUE + 1); // Blue
        }
    }

    // Update the frequency of red pixel values
    for (int i = 0; i < IMGY; i++) {
        for (int j = 0; j < IMGX; j++) {
            red_freq[img[i][j][0]] += 1;
        }
    }

    // Print the frequency of red pixel values
    for (int i = 0; i <= MAX_PIXEL_VALUE; i++) {
        printf("Red pixel value %d: %d occurrences\n", i, red_freq[i]);
    }

    return 0;
}