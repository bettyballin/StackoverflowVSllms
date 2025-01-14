// Point.h
#ifndef POINT_H
#define POINT_H

#define WIDTH 8U   // Use U suffix to denote WIDTH as being of unsigned char type
#define HEIGHT 8U  // Use U, since it's good practice when dealing with sizes and counts

typedef struct Point {
    unsigned char x;  // Use appropriate data types for coordinates that match the ranges.
    unsigned char y;
} Point;

#endif  // POINT_H