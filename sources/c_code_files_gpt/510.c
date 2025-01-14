#include <stdio.h>
#include <stdbool.h>

#define WIDTH 8
#define HEIGHT 8

typedef struct Point {
  signed char x;
  signed char y;
} Point;

bool inBounds(Point * p) {
  return p->x >= 0
    && p->x < WIDTH // Adjusted to ensure within bounds
    && p->y >= 0
    && p->y < HEIGHT; // Adjusted to ensure within bounds
}

int main() {
  Point p;
  p.x = 4;
  p.y = 4;
  
  if (inBounds(&p)) {
    printf("Point (%d, %d) is within bounds.\n", p.x, p.y);
  } else {
    printf("Point (%d, %d) is out of bounds.\n", p.x, p.y);
  }
  
  return 0;
}