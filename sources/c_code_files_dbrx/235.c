#include <stdio.h>
#include <math.h>

// Function to calculate the length of the cross product of two 2D vectors
float CrossProductLength(float vector1X, float vector1Y, float vector2X, float vector2Y) {
    return fabs(vector1X * vector2Y - vector1Y * vector2X);
}

// Function to calculate the cross product of two 2D vectors
float CrossProduct2DLength(float vector1X, float vector1Y, float vector2X, float vector2Y, float vector3X, float vector3Y) {
    float crossProduct = (vector2X - vector1X) * (vector3Y - vector1Y) - (vector2Y - vector1Y) * (vector3X - vector1X);
    return crossProduct;
}

int main() {
    // Define coordinates for points A, B, C, D, and P
    float ax = 0, ay = 0;
    float bx = 1, by = 0;
    float cx = 1, cy = 1;
    float dx = 0, dy = 1;
    float px = 0.5, py = 0.5;

    // Define edge lengths
    float length[4] = {1, 1, 1, 1};

    // Define epsilon for floating point comparison
    float epsilon = 0.00001;

    // Calculate vectors AB, AC, AD, and AP
    float abX = bx - ax, abY = by - ay;
    float acX = cx - ax, acY = cy - ay;
    float adX = dx - ax, adY = dy - ay;
    float apX = px - ax, apY = py - ay;

    // Calculate cross product lengths
    float d1 = CrossProductLength(abX, abY, apX, apY);
    float d2 = CrossProduct2DLength(adX, adY, acX, acY, abX, abY) * CrossProductLength(abX, abY, apX, apY);

    // Check conditions
    if (d1 > -epsilon && d1 < length[0] + epsilon && d2 > -epsilon) {
        printf("The point is in a specific region (top-left rectangle, bottom rectangle,...)\n");
    } else {
        printf("The point is not in the specific region\n");
    }

    return 0;
}