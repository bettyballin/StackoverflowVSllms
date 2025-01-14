#include <stdio.h>
#include <math.h>

// Define a function to calculate the dot product of two vectors
float dot(float x1, float y1, float x2, float y2) {
    return x1 * x2 + y1 * y2;
}

// Define a function to check if a point is within a certain distance from a line segment
int isCloseToLineSegment(float X, float Y, float A, float B, float d) {
    float AX_x = X - A;
    float AX_y = Y - 0; // Assuming Y-coordinate of A is 0
    float BX_x = X - B;
    float BX_y = Y - 0; // Assuming Y-coordinate of B is 0
    float AB_x = B - A;
    float AB_y = 0; // Since A and B have the same Y-coordinate
    float AB_sqLength = dot(AB_x, AB_y, AB_x, AB_y);
    
    if (d * d > dot(AX_x, AX_y, AX_x, AX_y)) return 1; // closer than d to A
    if (d * d > dot(BX_x, BX_y, BX_x, BX_y)) return 1; // closer than d to B

    float AB_dot_BX = dot(AB_x, AB_y, BX_x, BX_y);
    if (AB_dot_BX < 0 || AB_dot_BX > AB_sqLength) return 0; // behind A or beyond B

    return (d * d) * AB_sqLength - (AB_dot_BX * AB_dot_BX) < 0;
}

int main() {
    float X = 1.0;
    float Y = 2.0;
    float A = 0.0;
    float B = 3.0;
    float d = 1.5;

    int result = isCloseToLineSegment(X, Y, A, B, d);
    printf("%d\n", result);

    return 0;
}