#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int Columns;
char * Array[] = {"A", "B", "C", "D", "E", "F", "G"};

int main (
    int argc,
    char ** argv
) {
    // Lets thest this with all Column sizes from 1 to 7
    for (Columns = 1; Columns <= 7; Columns++) {

        printf("Output when Columns is set to %d\n", Columns);

        // This is hacky C for quickly get the number of entries
        // in a static array, where size is known at compile time
        int arraySize = sizeof(Array) / sizeof(Array[0]);

        // How many rows we will have
        int rows = arraySize / Columns;

        // Below code is the same as (arraySize % Columns != 0), but
        // it's almost always faster
        if (Columns * rows != arraySize) {
            // We might have lost one row by implicit rounding
            // performed for integer division
            rows++;
        }

        // Now we create a matrix large enough for rows * Columns
        // references. Note that this array could be larger than arraySize!
        char ** matrix = malloc(sizeof(char *) * rows * Columns);

        // Something you only need in C, C# and Java do this automatically:
        // Set all elements in the matrix to NULL(null) references
        memset(matrix, 0, sizeof(char *) * rows * Columns );

        // We fill up the matrix from top to bottom and then from
        // left to right; the order how we fill it up is very important
        int matrixX;
        int matrixY;
        int index = 0;
        for (matrixX = 0; matrixX < Columns; matrixX++) {
            for (matrixY = 0; matrixY < rows; matrixY++) {
                // In case we just have enough elements left to only
                // fill up the first row of the matrix and we are not
                // in this first row, do nothing.
                if (arraySize + matrixX + 1 - (index + Columns) == 0 &&
                        matrixY != 0) {
                    continue;
                }

                // We just copy the next element normally
                matrix[matrixY + matrixX * rows] = Array[index];
                index++;
                //arraySize--;
            }
        }

        // Print the matrix exactly like you'd expect a matrix to be
        // printed to screen, that is from left to right and top to bottom;
        // Note: That is not the order how we have written it,
        // watch the order of the for-loops!
        for (matrixY = 0; matrixY < rows; matrixY++) {
            for (matrixX = 0; matrixX < Columns; matrixX++) {
                // Skip over unset references
                if (matrix[matrixY + matrixX * rows] == NULL)
                    continue;

                printf("%s", matrix[matrixY + matrixX * rows]);
            }
            // Next row in output
            printf("\n");
        }
        printf("\n");

        // Free up unused memory
        free(matrix);
    }   
    return 0;
}