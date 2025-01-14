#define STB_IMAGE_IMPLEMENTATION
#include "stb_image.h"

#define STB_IMAGE_WRITE_IMPLEMENTATION
#include "stb_image_write.h"

#include <stdio.h>
#include <stdlib.h>

int main() {
    int width, height, channels;
    unsigned char *img = stbi_load("input.png", &width, &height, &channels, 0);
    if(img == NULL) {
        printf("Could not load image.\n");
        return 1;
    }
    printf("Loaded image with width: %d, height: %d, channels: %d\n", width, height, channels);

    // Optionally, convert the image to RGBA if it's not already
    if(channels != 4) {
        unsigned char *rgba_img = (unsigned char*) malloc(width * height * 4);
        if(rgba_img == NULL) {
            stbi_image_free(img);
            printf("Memory allocation failed for RGBA conversion.\n");
            return 1;
        }
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                for(int c = 0; c < channels; c++) {
                    rgba_img[y * width * 4 + x * 4 + c] = img[y * width * channels + x * channels + c];
                }
                if(channels < 4) rgba_img[y * width * 4 + x * 4 + 3] = 255; // Alpha channel to 255 for RGBA
            }
        }
        stbi_image_free(img);
        img = rgba_img;
        channels = 4;
    }

    // Save the image as a JPEG
    if(!stbi_write_jpg("output.jpg", width, height, channels, img)) {
        printf("Failed to write image as JPG.\n");
        free(img); // Free the allocated memory if we converted to RGBA
        return 1;
    }

    printf("Image saved successfully.\n");

    // Free the image if we converted it
    if(channels == 4) {
        free(img);
    } else {
        stbi_image_free(img); // Original stb_image's free function for consistency
    }

    return 0;
}