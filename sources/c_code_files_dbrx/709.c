#include <stdio.h>
#include <stdlib.h>

#define BLACK 0  // assuming BLACK is defined as 0

struct Pixel {
    int x;
    int y;
    int next_x;  // index in 'coords' of another black pixel to right or below the current one
    int prev_x;  // index in 'coords' for the last found black pixel left or above the current one, if any
};

int main() {
    // assuming img[] holds the image data and width/height define its dimensions
    int width = 100;  // example width
    int height = 100;  // example height
    int img[width * height];  // example image data

    // initialize image data
    for (int i = 0; i < width * height; ++i) {
        img[i] = i % 2 == 0 ? BLACK : 1;  // example image data
    }

    int count_black = 0;
    for (int i = 0; i < width * height; ++i) {  // iterate once to count black pixels
        if (img[i] == BLACK) count_black++;
    }

    if (count_black == 0) {
        printf("No black pixels found.\n");
        return 0;
    }

    struct Pixel* coords = malloc(count_black * sizeof(struct Pixel));  // allocate array for all coordinates
    if (coords == NULL) {
        printf("Memory allocation failed.\n");
        return 1;
    }

    int lastInd = -1;  // index of the latest stored coordinate in 'coords' array
    int j = 0;
    for (int i = 0; i < width * height && j < count_black; ++i) {
        if (img[i] == BLACK) {  // iterate again and store each black pixel's coordinates when found one
            coords[j].x = i % width;  // calculate x value for current black pixel
            coords[j].y = i / width;  // calculate y value for current black pixel
            lastInd++;
            j++;
        } else if (lastInd >= 0) {  // also set pointers during the second iteration
            // calculate index in 'coords' of another black pixel to right or below the current one
            coords[lastInd].next_x = (i + 1 < width * height && img[i + 1] == BLACK) ? lastInd + 1 : -1;

            // calculate index in 'coords' for the last found black pixel left or above the current one, if any
            coords[lastInd].prev_x = (i - 1 >= 0 && img[i - 1] == BLACK) ? lastInd - 1 : -1;
        }
    }

    // print the coordinates and next/prev indices for verification
    for (int i = 0; i < count_black; ++i) {
        printf("Coordinate (%d, %d) has next index %d and prev index %d\n", coords[i].x, coords[i].y, coords[i].next_x, coords[i].prev_x);
    }

    free(coords);  // free allocated memory

    return 0;
}