#include <stdint.h>
#include <stdlib.h>

#define NUM_BINS 256

void compute_color_histogram(uint32_t* image, int width, int height, int* histogram) {
    for (int i = 0; i < NUM_BINS; i++) {
        histogram[i] = 0;
    }

    for (int i = 0; i < width * height; i++) {
        uint32_t pixel = image[i];
        uint8_t r = (pixel >> 16) & 0xFF;
        uint8_t g = (pixel >> 8) & 0xFF;
        uint8_t b = pixel & 0xFF;

        int bin = (r + g + b) / 3; // Simple grayscale conversion
        histogram[bin]++;
    }
}

int main() {
    // Example usage:
    int width = 10;
    int height = 10;
    uint32_t* image = (uint32_t*) malloc(width * height * sizeof(uint32_t));
    int* histogram = (int*) malloc(NUM_BINS * sizeof(int));

    // Initialize image with some values
    for (int i = 0; i < width * height; i++) {
        image[i] = 0xFF0000; // Red color
    }

    compute_color_histogram(image, width, height, histogram);

    // Print histogram
    for (int i = 0; i < NUM_BINS; i++) {
        printf("%d: %d\n", i, histogram[i]);
    }

    free(image);
    free(histogram);

    return 0;
}