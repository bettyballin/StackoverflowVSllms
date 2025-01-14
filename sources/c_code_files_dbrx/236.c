#include <stdio.h>

int main() {
    // Assuming ghostX, ghostY, dx, and dy are defined somewhere
    int ghostX = 0;  // Initial ghost X position
    int ghostY = 0;  // Initial ghost Y position
    int dx = 1;      // Change in X position
    int dy = 1;      // Change in Y position

    ghostX += dx;      // Update ghost's X position based on calculated angle and its speed
    ghostY += dy;      // Update ghost's Y position based on calculated angle and its speed

    printf("Updated ghost position: (%d, %d)\n", ghostX, ghostY);

    return 0;
}