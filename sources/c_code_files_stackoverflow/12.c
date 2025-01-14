#include <stdio.h>

unsigned char calculate_gray(unsigned char r, unsigned char g, unsigned char b) {
    float gray = (r + g + b) / 3.0f;
    if (gray > 0x7F) return 0xFF;
    return 0x00;
}

int main() {
    unsigned char r = 128;
    unsigned char g = 128;
    unsigned char b = 128;
    unsigned char result = calculate_gray(r, g, b);
    printf("Result: 0x%02X\n", result);
    return 0;
}