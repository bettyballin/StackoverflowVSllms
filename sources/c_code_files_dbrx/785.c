#include <stdlib.h>
#include <stdint.h> // Add this line to include the definition of uint8_t and uint32_t

void rgb_to_argb(const uint8_t *rgb, uint32_t num_pixels, uint8_t *argb) {
    const size_t n = num_pixels;
    for (size_t i=0; i<n; ++i) {
        argb[4*i]   = 255;
        // alpha channel is already taken care of, now copy over the RGB values.
        argb[4*i+1] = rgb[3*i];    // red
        argb[4*i+2] = rgb[3*i + 1];// green
        argb[4*i+3] = rgb[3*i + 2];// blue
    }
}

int main() {
    // Add a main function to make the code executable
    return 0;
}