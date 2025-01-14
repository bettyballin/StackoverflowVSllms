#include <stdlib.h>
#include <stdio.h>
#include <time.h>

// Function to invert a square matrix
void invertMatrix(float *a, unsigned int height) {
    // Note: This is a very simplified version of matrix inversion.
    // Real matrix inversion is more complex and typically involves a library.
    int i, j, k;
    float temp;

    for (i = 0; i < height; i++) {
        // Search for maximum in this column
        float maxEl = abs(a[i * height + i]);
        int maxRow = i;
        for (k = i + 1; k < height; k++) {
            if (abs(a[k * height + i]) > maxEl) {
                maxEl = abs(a[k * height + i]);
                maxRow = k;
            }
        }

        // Swap maximum row with current row
        for (j = i; j < height; j++) {
            temp = a[maxRow * height + j];
            a[maxRow * height + j] = a[i * height + j];
            a[i * height + j] = temp;
        }

        // Make all rows below this one 0 in current column
        for (k = i + 1; k < height; k++) {
            float c = -a[k * height + i] / a[i * height + i];
            for (j = i; j < height; j++) {
                if (i == j) {
                    a[k * height + j] = 0;
                } else {
                    a[k * height + j] += c * a[i * height + j];
                }
            }
        }
    }

    // Solve equation Ax=b for an upper triangular matrix A
    for (i = height - 1; i >= 0; i--) {
        a[i * height + height] /= a[i * height + i];
        for (k = i - 1; k >= 0; k--) {
            a[k * height + height] -= a[k * height + i] * a[i * height + height];
        }
    }

    printf("Matrix Inversion is not fully implemented here due to complexity.\n");
    printf("The above steps only perform partial operations and actual inversion requires more steps.\n");
}

// Function to display a matrix
void displayMatrix(float *a, unsigned int height, unsigned int width) {
    int i, j;
    for (i = 0; i < height; i++) {
        for (j = 0; j < width; j++) {
            printf("%f ", a[i * width + j]);
        }
        printf("\n");
    }
}

// Function to multiply two matrices
void multiplyMatrix(float *a, unsigned int ah, unsigned int aw, float *b, unsigned int bw, float *c) {
    int i, j, k;
    for (i = 0; i < ah; i++) {
        for (j = 0; j < bw; j++) {
            c[i * bw + j] = 0;
            for (k = 0; k < aw; k++) {
                c[i * bw + j] += a[i * aw + k] * b[k * bw + j];
            }
        }
    }
}

int main() {
    unsigned int height = 2;
    unsigned int width = 2;
    float matrixA[] = {1.0, 2.0, 3.0, 4.0};
    float matrixB[] = {5.0, 6.0, 7.0, 8.0};
    float matrixC[4];

    printf("Matrix A:\n");
    displayMatrix(matrixA, height, width);

    printf("Matrix B:\n");
    displayMatrix(matrixB, height, width);

    multiplyMatrix(matrixA, height, width, matrixB, width, matrixC);

    printf("Matrix A * Matrix B:\n");
    displayMatrix(matrixC, height, width);

    // Note: The invertMatrix function as implemented does not actually invert a matrix.
    // It performs some operations but the actual inversion requires more complex steps.
    // Thus, calling it here is for demonstration of code structure but will not produce a correct matrix inversion.
    // invertMatrix(matrixA, height);

    return 0;
}