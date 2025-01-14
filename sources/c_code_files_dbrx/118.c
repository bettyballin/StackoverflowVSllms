#include <stdio.h>
#include <stdlib.h>

void allocate_matrix(int ***mat, int rows, int cols) {
    *mat = malloc(sizeof(int *) * rows); // Allocate memory for pointers to rows
    if (!*mat) {
        printf("Out of Memory\n");
        exit(-1);
    }
    for (int i = 0; i < rows; ++i){
        (*mat)[i] = malloc(sizeof(int)* cols); // Allocate memory for each row individually.
        if (!(*mat)[i]) {
            printf("Out of Memory\n");
            exit(-1);
        }
    }
}

void free_matrix(int **mat, int rows) { // Don't forget to always release the allocated memory once you are done.
    for (int i = 0; i < rows; ++i){
        if (mat[i]){ // Fix: Remove the dereference operator
            free(mat[i]);
        }
    }
    if (mat) { // Fix: Remove the dereference operator
        free(mat);
    }
}

// Function to demonstrate the use of m[line][column].
void access_elements(int **m, int rows, int cols){
   for (int i = 0; i < rows; ++i){
       for (int j = 0; j < cols; ++j) {
           printf("Element at m[%d][%d] is: ",i,j);
            // Assign values or print elements using double indexing `m[line][column]`.
            m[i][j] = i*10+ j;  // Example how to do an assignement.
           printf("%d\n",m[i][j]); // Print the element.
       }
    }
}

int main() {
    int **matrix;
    const int rows = 3, cols = 4;

    allocate_matrix(&matrix, rows, cols); // Pass address of matrix pointer to change its value.
    printf("Demonstration on how to assign values or print elements.\n");
    access_elements(matrix,rows,cols);
    free_matrix(matrix, rows);

    return 0;
}