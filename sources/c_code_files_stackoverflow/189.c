#include <stdio.h>

// Function prototype for setPixel
void setPixel(int x, int y);

int main() {
    int x0 = 0;  // Initialize x0
    int y0 = 0;  // Initialize y0
    int x = 0;   // Initialize x
    int y = 0;   // Initialize y

    // Set pixels
    setPixel(x0 + x, y0 + y);
    setPixel(x0 - x, y0 + y);

    return 0;
}

// Function definition for setPixel
void setPixel(int x, int y) {
    // Implementation of setPixel function
    printf("Setting pixel at (%d, %d)\n", x, y);
}