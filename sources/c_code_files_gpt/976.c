#include <stdio.h>
#include <math.h>

#define ABS(x) ((x) < 0 ? -(x) : (x))
#define EPS 1e-6
#define FALSE 0

typedef struct {
    double x, y, z;
} Point;

int main() {
    Point p43;
    p43.x = 0.0;
    p43.y = 0.0;
    p43.z = 0.0;

    if (ABS(p43.x) < EPS && ABS(p43.y) < EPS && ABS(p43.z) < EPS) 
        return FALSE;

    return 0;
}