#include <stdio.h>
#include <stdlib.h>
#include <math.h>

// Assuming _width, L, _data, _offsetx, Value2Pixel, g, bm, and pen are defined elsewhere
int _width = 100; // Replace with actual value
int L = 100; // Replace with actual value
double *_data = NULL; // Replace with actual data
int _offsetx = 0; // Replace with actual value
int Value2Pixel(double value) { return (int)value; } // Replace with actual function
void *g = NULL; // Replace with actual graphics object
void *bm = NULL; // Replace with actual bitmap
void *pen = NULL; // Replace with actual pen

int __min(int a, int b) { return a < b ? a : b; }
int __max(int a, int b) { return a > b ? a : b; }

int main() {
    double samplesPerPixel = (double)L / _width;
    double firstSample = 0;
    int endSample = firstSample + L - 1;
    for (short pixel = 0; pixel < _width; pixel++)
    {
        int lastSample = __min(endSample, (int)(firstSample + samplesPerPixel));
        double Y = _data[0][(int)firstSample]; // Assuming channel is 0
        double minY = Y;
        double maxY = Y;
        for (int sample = (int)firstSample + 1; sample <= lastSample; sample++)
        {
            Y = _data[0][sample]; // Assuming channel is 0
            minY = __min(Y, minY);
            maxY = __max(Y, maxY);
        }
        int x = pixel + _offsetx;
        int y1 = Value2Pixel(minY);
        int y2 = Value2Pixel(maxY);
        if (y1 == y2)
        {
            // g->DrawImageUnscaled(bm, x, y1);
            // Replace with actual drawing function
        }
        else
        {
            // g->DrawLine(pen, x, y1, x, y2);
            // Replace with actual drawing function
        }
        firstSample += samplesPerPixel;
    }
    return 0;
}