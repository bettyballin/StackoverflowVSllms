#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/* global definitions */
#define WIDTH 480
#define HEIGHT 240

/* global declarations */
int w = 100, h = 100, scrn = 0, bytewrite = 0;
unsigned char red, green, blue;
static unsigned long rgb[WIDTH][HEIGHT];

/* function declarations */
void colorq();
void rgb_rectdraw(int x, int y, int w, int h, unsigned char red, unsigned char green, unsigned char blue, unsigned long rgb[WIDTH][HEIGHT]);
void rgb2yuv(unsigned long rgb[WIDTH][HEIGHT]);

/*
 Function Name: main
 Purpose: main function
*/
int main(int argc, char **argv) {
    printf("\n");
    int x = 0, y = 0;

    /* call colorq to create a 32-bit number of RGB */
    colorq();

    /* call rgb_rectdraw to draw a rectangle RGB array */
    rgb_rectdraw(x, y, w, h, red, green, blue, rgb);

    /* call rgb2yuv to take the RGB array and convert it to a YUV array */
    rgb2yuv(rgb);
    return 0;
}

/*
 Function name: colorq
 Purpose: asks user to input colors from 0 to 255 in RGB format
*/
void colorq() {
    printf("Please enter a color for Red Green and Blue from 0 to 255:\n");
    scanf("%hhu", &red);
    scanf("%hhu", &green);
    scanf("%hhu", &blue);
    printf("\n");
    return;
}

/*
 Function name: rectdraw
 Purpose: Draws a rectangle array
*/
void rgb_rectdraw(int x, int y, int w, int h, unsigned char red, unsigned char green, unsigned char blue, unsigned long rgb[WIDTH][HEIGHT]) {
    unsigned long rgbpixel;

    /* creates a 32-bit number of RGB */
    rgbpixel = (red << 16) | (green << 8) | blue;

    for (int i = y; i < y + h; i++) {
        for (int j = x; j < x + w; j++) {
            if (i < HEIGHT && j < WIDTH) {
                rgb[j][i] = rgbpixel;
            }
        }
    }
}

/*
 Function name: rgb2yuv
 Purpose: Converts RGB to YUV
*/
void rgb2yuv(unsigned long rgb[WIDTH][HEIGHT]) {
    for (int i = 0; i < HEIGHT; i++) {
        for (int j = 0; j < WIDTH; j++) {
            unsigned long pixel = rgb[j][i];
            printf("RGB Pixel at [%d][%d]: %lx\n", j, i, pixel); // Debugging statement
            // Conversion logic here...
        }
    }
}