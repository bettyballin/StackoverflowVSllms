#include <stdio.h>

#define WIDTH 40
#define HEIGHT 20

void putPixel(int x, int y) {
    if (x >= 0 && x < WIDTH && y >= 0 && y < HEIGHT) {
        printf("\x1B[%d;%dH*", y + 1, x + 1);
    }
}

void drawFilledCircle(int x0, int y0, int radius) {
    int x = radius;
    int y = 0;
    int dx = 1 - 2 * radius;
    int dy = 1;
    int err = 0;

    while (x >= y) {
        // draw horizontal line segment from (y0 + y, x0 - x) to (y0 + y, x0 + x)
        for (int i = x0 - x; i <= x0 + x; i++) {
            putPixel(i, y0 + y);
            putPixel(i, y0 - y);
        }

        // draw horizontal line segment from (y0 - y, x0 - x) to (y0 - y, x0 + x)
        for (int i = x0 - x; i <= x0 + x; i++) {
            putPixel(i, y0 - y);
        }

        err += dy;
        dy += 2;
        if (err > 0) {
            x--;
            dx += 2;
            err += dx;
        }
        y++;
    }
}

void clearScreen() {
    printf("\033[2J\033[1;1H");
}

int main() {
    clearScreen();
    drawFilledCircle(WIDTH / 2, HEIGHT / 2, 10);
    // Move cursor to the bottom to prevent overwrite
    printf("\x1B[%d;%dH", HEIGHT + 1, 1);
    return 0;
}