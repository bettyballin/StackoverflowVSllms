#include <stdio.h>

// Define a structure for a rectangle
typedef struct {
    int Left;
    int Right;
    int Top;
    int Bottom;
} Rectangle;

// Function to check if two rectangles overlap
int rectanglesOverlap(Rectangle RectA, Rectangle RectB) {
    if (RectA.Left < RectB.Right && RectA.Right > RectB.Left &&
        RectA.Top < RectB.Bottom && RectA.Bottom > RectB.Top) {
        return 1; // Rectangles overlap
    }
    return 0; // Rectangles do not overlap
}

int main() {
    Rectangle RectA = {0, 5, 5, 0}; // Example coordinates for RectA
    Rectangle RectB = {3, 7, 7, 3}; // Example coordinates for RectB

    if (rectanglesOverlap(RectA, RectB)) {
        printf("The rectangles overlap.\n");
    } else {
        printf("The rectangles do not overlap.\n");
    }

    return 0;
}