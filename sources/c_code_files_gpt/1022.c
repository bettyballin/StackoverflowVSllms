#include <stdio.h>
#include <stdlib.h>

void plot(int x, int y) {
    // Implement your plotting function here
    // For example: setPixel(x, y);
}

void drawHorizontalLine(int x1, int x2, int y) {
    for (int x = x1; x <= x2; x++) {
        plot(x, y);
    }
}

void drawFilledCircle(int xc, int yc, int radius) {
    int x = 0;
    int y = radius;
    int d = 3 - 2 * radius;

    while (y >= x) {
        // Draw horizontal lines between the points on the circle's perimeter
        drawHorizontalLine(xc - x, xc + x, yc + y);
        drawHorizontalLine(xc - y, xc + y, yc + x);
        drawHorizontalLine(xc - x, xc + x, yc - y);
        drawHorizontalLine(xc - y, xc + y, yc - x);

        x++;

        if (d > 0) {
            y--;
            d = d + 4 * (x - y) + 10;
        } else {
            d = d + 4 * x + 6;
        }
    }
}

int main() {
    int xc = 50; // X-coordinate of the circle center
    int yc = 50; // Y-coordinate of the circle center
    int radius = 20; // Radius of the circle

    drawFilledCircle(xc, yc, radius);

    return 0;
}