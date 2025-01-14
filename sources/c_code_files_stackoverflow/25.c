#include <stdio.h>

int main() {
    unsigned int pixel = 0x123456;  // example pixel value

    int r = (pixel & 0xff0000) >> 16;
    int g = (pixel & 0xff00) >> 8;
    int b = pixel & 0xff;

    printf("Red: %d, Green: %d, Blue: %d\n", r, g, b);

    return 0;
}