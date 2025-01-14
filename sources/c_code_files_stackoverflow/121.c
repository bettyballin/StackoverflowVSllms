#include <stdio.h>

typedef struct {
    int R, G, B;
} Color;

int main() {
    Color grayVal = {100, 100, 100}; // example gray value
    Color colorize = {200, 200, 200}; // example colorize value
    int rNew = (grayVal.R / 2) + (colorize.R / 2);
    printf("rNew: %d\n", rNew);
    return 0;
}