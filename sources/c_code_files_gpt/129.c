#include <stdio.h>

#define STB_IMAGE_IMPLEMENTATION
#include "stb_image.h"

int main() {
    int width, height, channels;
    unsigned char *img = stbi_load("input.jpg", &width, &height, &channels, 0);
    if (img == NULL) {
        printf("Error loading image\n");
        return 1;
    }
    // Use the image data in img
    stbi_image_free(img);
    return 0;
}