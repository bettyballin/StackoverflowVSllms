#include <stdio.h>
#include <stdlib.h>

void print2DArray(int rows, int cols, int **arr) {
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            printf("%d ", arr[i][j]);
        }
        printf("\n");  // Corrected the newline character
    }
}

int main() {
    int rows = 2, cols = 3;
    int **arr = malloc(rows * sizeof(int *));
    for (int i = 0; i < rows; i++) {
        arr[i] = malloc(cols * sizeof(int));
        for (int j = 0; j < cols; j++) {
            arr[i][j] = i * cols + j + 1;
        }
    }
    
    print2DArray(rows, cols, arr);
    
    for (int i = 0; i < rows; i++) {
        free(arr[i]);
    }
    free(arr);
    
    return 0;
}