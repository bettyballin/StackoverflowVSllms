#include <stdio.h>
#include <stdlib.h>

void matrix_multiply(int n, double *restrict A, double *restrict B, double *restrict C) {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            C[i * n + j] = 0;
            for (int k = 0; k < n; k++) {
                C[i * n + j] += A[i * n + k] * B[k * n + j];
            }
        }
    }
}

int main() {
    int n = 2;
    double A[n * n] = {1, 2, 3, 4};
    double B[n * n] = {5, 6, 7, 8};
    double C[n * n];

    matrix_multiply(n, A, B, C);

    printf("Matrix A:\n");
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            printf("%f ", A[i * n + j]);
        }
        printf("\n");
    }

    printf("Matrix B:\n");
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            printf("%f ", B[i * n + j]);
        }
        printf("\n");
    }

    printf("Matrix C (result):\n");
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            printf("%f ", C[i * n + j]);
        }
        printf("\n");
    }

    return 0;
}