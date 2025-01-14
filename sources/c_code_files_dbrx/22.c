#include <stdbool.h>
#include <stdio.h>

bool are_matrices_equal(int m, int n, int** matrix1, int** matrix2) {
    for (int i = 0; i < m; ++i) {
        for (int j = 0; j < n; ++j) {
            if (matrix1[i][j] != matrix2[i][j]) {
                // Return indices and false to indicate inequality.
                printf("Mismatch at [%d][%d]: %d!=%d\n", i, j, matrix1[i][j], matrix2[i][j]);
                return false;
            }
        }
    }
    // No mismatches found, therefore matrices are equal.
    return true;
}

int main() {
    // Example usage:
    int m = 2;
    int n = 2;
    int matrix1[][2] = {{1, 2}, {3, 4}};
    int matrix2[][2] = {{1, 2}, {3, 4}};

    int* arr1[2];
    int* arr2[2];
    for (int i = 0; i < m; i++) {
        arr1[i] = matrix1[i];
        arr2[i] = matrix2[i];
    }

    bool result = are_matrices_equal(m, n, arr1, arr2);
    printf("Matrices are equal: %s\n", result ? "true" : "false");

    return 0;
}