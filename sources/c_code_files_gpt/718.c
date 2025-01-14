#include <stdio.h>
#include <stdlib.h>

// Define a structure to hold the x and y positions
typedef struct {
    int x;
    int y;
} PixelPosition;

int main() {
    int width = 100;  // Example image width
    int height = 100; // Example image height

    // Example image data (1 for black pixel, 0 for white pixel)
    int image[100][100] = { /* Initialize your image data here */ };

    // Step 1: Count black pixels
    int blackPixelCount = 0;
    for (int y = 0; y < height; y++) {
        for (int x = 0; x < width; x++) {
            if (image[y][x] == 1) {
                blackPixelCount++;
            }
        }
    }

    // Step 2: Allocate a large chunk of memory for black pixel positions
    PixelPosition* blackPixels = (PixelPosition*)malloc(blackPixelCount * sizeof(PixelPosition));
    if (blackPixels == NULL) {
        perror("Failed to allocate memory");
        return 1;
    }

    // Step 3: Store black pixel positions in the allocated array
    int index = 0;
    for (int y = 0; y < height; y++) {
        for (int x = 0; x < width; x++) {
            if (image[y][x] == 1) {
                blackPixels[index].x = x;
                blackPixels[index].y = y;
                index++;
            }
        }
    }

    // Use the blackPixels array as needed...

    // Free the allocated memory
    free(blackPixels);

    return 0;
}