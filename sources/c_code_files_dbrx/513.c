#include <stdio.h>
#include <math.h>

int main() {
    int i = 10; // Replace with your desired value
    int M = 5;  // Replace with your desired value
    int row_index = 2;  // Replace with your desired value

    if (i <= M) { 
        // Check for diagonal elements of upper triangular matrix.
        int column_index = i;
        printf("Column index: %d\n", column_index);
    } else if (((int)M * ((int)M + 1)) / 2 > i ) {
        // Subtract the sum from 0 to `row`-th row, from 'i' to get a value in the range [0...N - r].
        int column_index = i - (row_index * ((row_index) + 1)) / 2;
        printf("Column index: %d\n", column_index);
    } else { 
        // check for invalid indices.
        printf("Error: Invalid index %d, out of the range [0...(%d)^2 - 1]\n", 
               i, (int)(sqrt(8 *i + 1) - 1)/2);
    }

    return 0;
}