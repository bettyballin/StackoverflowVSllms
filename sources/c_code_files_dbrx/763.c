#include <stdio.h>
#define STB_IMAGE_IMPLEMENTATION
#include "stb_image.h"

int main(void) {
   int width, height, channels;
   unsigned char *data = stbi_load("test_image.jpg", &width, &height, &channels, 0);
   if (data == NULL) {
       fprintf(stderr, "Failed to open the image file!\n");
       return 1;
    }

    // Process your pixels here...

    stbi_image_free(data);
    return 0;
}