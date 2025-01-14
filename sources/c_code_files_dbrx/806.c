#include <stdio.h>
#include <stdlib.h>

// Define a placeholder for the drawRect function
void drawRect(int x, int y, int width) {
    // You need to implement this function or replace it with a real implementation
    printf("Drawing rectangle at (%d, %d) with width %d\n", x, y, width);
}

void thick_line(int x0, int y0, int x1, int y1, int thickness) {
    int dx = abs(x1 - x0), sx = x0 < x1 ? 1 : -1;
    int dy = abs(y1 - y0), sy = y0 < y1 ? 1 : -1;
    int err = (dx > dy ? dx : -dy) / 2, e2;

    for (;;) {
        // Draw a rectangle of given thickness at each pixel position.
        for(int i=y0-thickness/2; i<=y1+thickness/2;i++){
            drawRect(x0 - thickness / 2, i, thickness);
        }

        if (x0 == x1 && y0 == y1) break;
        e2 = err;
        if (e2 > -dx) { err -= dy; x0 += sx; }
        if (e2 < dy) { err += dx; y0 += sy; }
    }
}

int main() {
    // Call the thick_line function to test it
    thick_line(10, 10, 20, 20, 5);
    return 0;
}