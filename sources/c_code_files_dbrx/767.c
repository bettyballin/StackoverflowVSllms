#include <stdio.h>
#include <stdbool.h>

// Stack size should be a large value, depending on the image size
typedef struct {
    int x;
    int y;
} Point2d;

const int MAX_WIDTH  = 800; // Set this according to your requirements
const int MAX_HEIGHT = 600; // Set this according to your requirements
const int STACK_SIZE = 100000;

void fill(int x, int y, unsigned char image[MAX_HEIGHT][MAX_WIDTH], unsigned char targetColor, unsigned char newColor) {
    Point2d stack[STACK_SIZE]; // Use an array as a "stack" for the coordinate data
    int sp = 0; // Stack pointer, initially points to the bottom of the array

    if (x < 0 || y < 0 || x >= MAX_WIDTH || y >= MAX_HEIGHT) {
        return; // The index is out of bounds, stop here.
    } else if (image[y][x] != targetColor) {
        return; // Not the same color as to be filled.
    }

    int widthHeight[] = {0, 1}; // Array for looping through x and y coordinates.
    image[y][x] = newColor; // Begin coloring the pixel at the given location (x, y) with a new color.

    Point2d idx = {x, y}; // Initialize idx with the starting point
    stack[sp++] = idx; // Push the starting point onto the stack

    while (sp > 0) {
        idx = stack[sp-1]; // Get current coordinates from the top of stack pointer
        int x = idx.x;
        int y = idx.y;

        while ((sp >= 2 && stack[sp-2].x == x + widthHeight[stack[sp - 1].x % 2] * -1 && stack[sp-2].y == y) || 
               (sp >= 4 && stack[sp-2].x == x + widthHeight[(stack[sp - 1].x - stack[sp - 3].x) % 2] * -1 && stack[sp-2].y == y)) { 
            sp -= 4; // In case we found a cycle, cut it off.
        }

        for (int k = 0; k < 2 * 2 - 1; k++) { 
            Point2d newPoint;
            newPoint.x = x + widthHeight[(k / 2) % 2] * (1 - k % 2) * 2 - 1;
            newPoint.y = y + ((0 == stack[sp-1].x % 2 ? 0 : 1) ^ k % 2); 

            if (newPoint.x >= 0 && newPoint.y >= 0 && newPoint.x < MAX_WIDTH && newPoint.y < MAX_HEIGHT
                && image[newPoint.y][newPoint.x] == targetColor) { 
                stack[sp++] = newPoint;
            }
        }

        sp--; // Pop the current point from the stack
    }
}

int main() {
    unsigned char image[MAX_HEIGHT][MAX_WIDTH];
    // Initialize the image with some values
    for (int i = 0; i < MAX_HEIGHT; i++) {
        for (int j = 0; j < MAX_WIDTH; j++) {
            image[i][j] = 0;
        }
    }

    // Test the fill function
    fill(10, 10, image, 0, 255);

    return 0;
}