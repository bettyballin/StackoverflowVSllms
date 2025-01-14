#include <stdio.h>

// Assuming WIDTH and HEIGHT are defined somewhere
#define WIDTH 10
#define HEIGHT 10

// Assuming rgb is a 2D array of integers
unsigned int rgb[WIDTH + 1][HEIGHT + 1];

int main() {
    // Initialize rgb array (example values)
    for (int i = 0; i <= WIDTH; i++) {
        for (int j = 0; j <= HEIGHT; j++) {
            rgb[i][j] = i * j; // example value
        }
    }

    for (int i = 0; i <= WIDTH; i++) {
        for (int j = 0; j <= HEIGHT; j++) {
            printf("%#x ", rgb[i][j]);
        }
        printf("\n");
    }

    return 0;
}