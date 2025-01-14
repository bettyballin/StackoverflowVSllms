#include <stdio.h>

void print2DArray(int rows, int cols, int arr[rows][cols]) {
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            printf("%d ", arr[i][j]);
        }
        printf("\n");
    }
}

int main() {
    int arr[2][3] = { {1, 2, 3}, {4, 5, 6} };
    print2DArray(2, 3, arr);
    return 0;
}