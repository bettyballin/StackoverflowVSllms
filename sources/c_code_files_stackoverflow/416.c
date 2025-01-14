#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include <errno.h>
#include <string.h>

#define WIDTH 480
#define HEIGHT 240

int w, h, scrn, bytewrite;
unsigned short red, green, blue;
static unsigned long rgb[WIDTH][HEIGHT];

void colorq();
void rgb_rectdraw(int x, int y, int w, int h, unsigned char red,
                  unsigned char green, unsigned char blue,
                  unsigned long rgb[][HEIGHT]);
void rgb2yuv(unsigned long rgb[][HEIGHT]);

int main(int argc, char** argv) {
    printf("\n");
    int x, y;

    colorq();

    rgb_rectdraw(x, y, w, h, red, green, blue, rgb);

    rgb2yuv(rgb);

    return 0;
}

void colorq() {
    printf("Please enter a color for Red Green and Blue from 0 to 255:\n");
    scanf("%hu", &red);
    scanf("%hu", &green);
    scanf("%hu", &blue);
    printf("\n");

    return;
}

void rgb_rectdraw(int x, int y, int w, int h, unsigned char red,
                  unsigned char green, unsigned char blue,
                  unsigned long rgb[][HEIGHT]) {
    unsigned long rgbpixel;

    red = 255;
    printf("red set to 255 for debugging\n");

    rgbpixel = ((red & 0xFF) << 16) | ((green & 0xFF) << 8) | (blue & 0xFF);
    printf("%#lx\n", rgbpixel);

    memset(rgb, 0, sizeof(unsigned long) * HEIGHT * WIDTH);
    int i, j, startx, stopx, starty, stopy;

    printf("enter width and height of rectangle in pixels\n");
    scanf("%d %d", &w, &h);

    printf("enter offset x pixels and y pixels of rectangle:\n");
    scanf("%d %d", &x, &y);

    startx = x;
    starty = y;
    stopx = x + w;
    stopy = y + h; // changed from w to h

    for (i = startx; i <= stopx; i++) {
        for (j = starty; j <= stopy; j++) {
            rgb[i][j] = rgbpixel;
        }
        j = 0;
    }
    printf("original rgb %#lx\n", (long unsigned int) rgb);
    return;
}

void rgb2yuv(unsigned long rgb[][HEIGHT]) {
    int i, j;
    printf("ptrpassed = %#lx\n", rgb[0][0]);
    for (i = 0; i < WIDTH; i++) { // changed from <= to <
        for (j = 0; j < HEIGHT; j++) { // changed from <= to <
        }
    }
    printf("\n");
    return;
}