#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <GL/gl.h> // Assuming you're working with OpenGL for the GLubyte type

// Function to find the minimum of two floats
float min(float a, float b) {
    return (a < b) ? a : b;
}

// Function to find the maximum of two floats
float max(float a, float b) {
    return (a > b) ? a : b;
}

int main() {
    // Define the dimensions and color components of the texture
    int original_width = 512; // Example width
    int original_height = 512; // Example height
    int color_components = 4; // Example for RGBA

    // Define the thresholds and desired output range
    float lower = 0.0f; // Example minimum value
    float upper = 255.0f; // Example maximum value
    float desired_lower = 0.0f; // Example desired minimum output
    float desired_upper = 255.0f; // Example desired maximum output
    float desired_min = 0.0f; // Desired minimum output
    float desired_max = 255.0f; // Desired maximum output

    // Allocate memory for the original and temporary textures
    unsigned char *original_texture = (unsigned char *)malloc(original_width * original_height * color_components);
    unsigned char *temp_texture = (unsigned char *)malloc(original_width * original_height * color_components);

    // Initialize the original_texture with some data (this is a placeholder)
    for (int i = 0; i < original_width * original_height * color_components; ++i) {
        original_texture[i] = i % 256; // Just an example initialization
    }

    // Perform the contrast stretching or normalization
    for (int i = 0; i < original_width * original_height * color_components; ++i) {
        float value = (float)original_texture[i] / (max(lower, upper) - min(lower, upper)) + fabs(min(lower, upper));
        
        if (value <= desired_lower) {
            temp_texture[i] = 0;
        } else if (value >= desired_upper) {
            temp_texture[i] = 255;
        } else {
            float scale = (desired_max - desired_min) / 1.0f;
            temp_texture[i] = (unsigned char)min((255 * (value / scale) + 0.5f), 255.0f);
        }
    }

    // Clean up
    free(original_texture);
    free(temp_texture);

    return 0;
}