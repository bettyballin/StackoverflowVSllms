#include <stdio.h>
#include <stdlib.h>

void convertRGBtoARGB(const unsigned char* rgbData, unsigned int* argbData, size_t pixelCount) {
    for (size_t i = 0; i < pixelCount; ++i) {
        unsigned char r = rgbData[i * 3];
        unsigned char g = rgbData[i * 3 + 1];
        unsigned char b = rgbData[i * 3 + 2];
        argbData[i] = (255 << 24) | (r << 16) | (g << 8) | b;
    }
}

int main() {
    // Example usage
    size_t pixelCount = 3; // Example with 3 pixels
    unsigned char rgbData[] = {
        255, 0, 0, // Red
        0, 255, 0, // Green
        0, 0, 255  // Blue
    };
    
    unsigned int* argbData = (unsigned int*)malloc(pixelCount * sizeof(unsigned int));
    if (!argbData) {
        fprintf(stderr, "Memory allocation failed\n");
        return 1;
    }

    convertRGBtoARGB(rgbData, argbData, pixelCount);

    for (size_t i = 0; i < pixelCount; ++i) {
        printf("ARGB Pixel %zu: 0x%08X\n", i, argbData[i]);
    }

    free(argbData);
    return 0;
}