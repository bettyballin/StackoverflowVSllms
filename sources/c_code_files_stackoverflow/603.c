#include <stdio.h>

// Define a struct to represent a point
typedef struct {
    int x;
    int y;
} Point;

// Function to compare two points based on the given criteria
void comparePoints(Point a, Point b) {
    if (a.y > b.y)
        printf("a is before b\n");
    else if (a.x < b.x)
        printf("a is before b\n");
    else
        printf("b is before a\n");
}

int main() {
    // Example usage
    Point a = {1, 2};
    Point b = {3, 4};
    
    printf("Comparing points (%d, %d) and (%d, %d):\n", a.x, a.y, b.x, b.y);
    comparePoints(a, b);
    
    return 0;
}