#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void matrixMultiply(int n) {
    int i, j, k;
    double **a = malloc(n * sizeof(double *));
    double **b = malloc(n * sizeof(double *));
    double **c = malloc(n * sizeof(double *));
    
    for (i = 0; i < n; i++) {
        a[i] = malloc(n * sizeof(double));
        b[i] = malloc(n * sizeof(double));
        c[i] = malloc(n * sizeof(double));
    }
    
    // Initialize matrices with random values
    srand(time(NULL));
    for (i = 0; i < n; i++) {
        for (j = 0; j < n; j++) {
            a[i][j] = rand() % 100;
            b[i][j] = rand() % 100;
            c[i][j] = 0;
        }
    }

    // Matrix multiplication
    for (i = 0; i < n; i++) {
        for (j = 0; j < n; j++) {
            for (k = 0; k < n; k++) {
                c[i][j] += a[i][k] * b[k][j];
            }
        }
    }

    // Free memory
    for (i = 0; i < n; i++) {
        free(a[i]);
        free(b[i]);
        free(c[i]);
    }
    free(a);
    free(b);
    free(c);
}

int main() {
    int n = 500; // Size of the NxN matrix
    matrixMultiply(n);
    return 0;
}