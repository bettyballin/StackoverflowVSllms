#define STB_IMAGE_IMPLEMENTATION
#include "stb_image.h"

#define STB_IMAGE_WRITE_IMPLEMENTATION
#include "stb_image_write.h"

#include <stdio.h>

int main() {
    int width, height, channels;
    unsigned char *img = stbi_load("input.jpg", &width, &height, &channels, 0);
    if(img == NULL) {
        printf("Failed to load image\n");
        return 1;
    }

    // Process the image data (e.g., resize, compress, etc.)

    // Save the image in JPEG format with a quality level of 90
    if(stbi_write_jpg("output.jpg", width, height, channels, img, 90) == 0) {
        printf("Failed to write image\n");
        stbi_image_free(img);
        return 1;
    }

    stbi_image_free(img);
    printf("Image processed and saved successfully\n");
    return 0;
}