#include <stdio.h>

int main() {
    int a[4], b[4], c[4];

    // Initialize arrays b and c
    for (int i = 0; i < 4; ++i) {
        b[i] = i;
        c[i] = i * 2;
    }

    // Perform the operation
    for (int i = 0; i < 4; ++i) {
        a[i] = b[i] + c[i];
    }

    // Print the result
    for (int i = 0; i < 4; ++i) {
        printf("%d ", a[i]);
    }
    printf("\n");

    return 0;
}