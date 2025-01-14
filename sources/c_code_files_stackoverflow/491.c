#include <stdio.h>
#include <math.h>

unsigned int row_index(unsigned int i, unsigned int M) {
    double m = M;
    double row = (-2*m - 1 + sqrt((4*m*(m+1) - 8*(double)i - 7))) / -2;
    if (row == (double)(int)row) row -= 1;
    return (unsigned int)row;
}

unsigned int column_index(unsigned int i, unsigned int M) {
    unsigned int row = row_index(i, M);
    return i - M * row + row*(row+1) / 2;
}

int main() {
    unsigned int i = 10; // example index
    unsigned int M = 5;  // example number of columns
    unsigned int row = row_index(i, M);
    unsigned int col = column_index(i, M);
    printf("Row index: %u\n", row);
    printf("Column index: %u\n", col);
    return 0;
}