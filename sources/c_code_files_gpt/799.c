#include <stdio.h>
#include <stdlib.h>

void plot(int x, int y) {
    // Function to plot a point at (x, y)
    // Replace this with actual plotting code
    printf("Plotting point at (%d, %d)\n", x, y);
}

void drawThickLine(int x0, int y0, int x1, int y1, int thickness) {
    int dx = abs(x1 - x0);
    int dy = abs(y1 - y0);
    int sx = x0 < x1 ? 1 : -1;
    int sy = y0 < y1 ? 1 : -1;
    int err = dx - dy;
    
    // Calculate offset for thickness
    int offset = thickness / 2;
    
    for (int i = -offset; i <= offset; i++) {
        int x = x0;
        int y = y0;
        int e2;

        while (1) {
            for (int j = -offset; j <= offset; j++) {
                // Plot points for thickness
                if (abs(x1 - x0) >= abs(y1 - y0))
                    plot(x, y + j);
                else
                    plot(x + j, y);
            }
            if (x == x1 && y == y1) break;
            e2 = 2 * err;
            if (e2 > -dy) {
                err -= dy;
                x += sx;
            }
            if (e2 < dx) {
                err += dx;
                y += sy;
            }
        }
    }
}

int main() {
    int x0 = 10, y0 = 10, x1 = 20, y1 = 20, thickness = 3;
    drawThickLine(x0, y0, x1, y1, thickness);
    return 0;
}