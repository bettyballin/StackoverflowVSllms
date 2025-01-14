#include <stdio.h>

// Define the SUB, ROW, and COL macros
#define SUB(n) ((n) * 9)
#define ROW(n) ((n) * 9)
#define COL(n) ((n))

// Define the doOperation function
void doOperation(int *element) {
    // Replace this with your actual operation
    printf("%d\n", *element);
}

void applyThingy(int *grid, int xPitch, int yPitch) {
    int row, column;
    int *rowPointer = grid;

    for(row = 0; row < 3; ++row) {
        int *columnPointer = rowPointer;

        for(column = 0; column < 3; ++column) {
            doOperation(columnPointer);
            columnPointer += xPitch;
        }

        rowPointer += yPitch * 9;
    }
}

int main() {
    int grid[9] = {1, 2, 3, 4, 5, 6, 7, 8, 9}; // Example grid

    applyThingy(&grid[SUB(0)], 1, 1); // Perform on 3x3 subgrid
    applyThingy(&grid[ROW(0)], 1, 0); // Perform on row
    applyThingy(&grid[COL(0)], 0, 1); // Perform on column

    return 0;
}