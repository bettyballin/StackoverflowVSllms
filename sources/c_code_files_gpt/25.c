#include <stdio.h>
#include <stdlib.h>

void apply_filter(int width, int height, unsigned char *restrict input, unsigned char *restrict output) {
    for (int y = 0; y < height; y++) {
        for (int x = 0; x < width; x++) {
            // Apply some filter operation
            output[y * width + x] = input[y * width + x] / 2; // Example operation
        }
    }
}

int main() {
    int width = 10;
    int height = 10;
    unsigned char *input = (unsigned char *)malloc(width * height * sizeof(unsigned char));
    unsigned char *output = (unsigned char *)malloc(width * height * sizeof(unsigned char));

    // Initialize input with some values
    for (int i = 0; i < width * height; i++) {
        input[i] = i;
    }

    apply_filter(width, height, input, output);

    // Print output
    for (int i = 0; i < width * height; i++) {
        printf("%d ", output[i]);
    }
    printf("\n");

    free(input);
    free(output);

    return 0;
}