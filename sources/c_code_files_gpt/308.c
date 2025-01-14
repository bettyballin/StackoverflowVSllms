#include <stdio.h>

int main() {
    int array[1000];
    int sum = 0;

    // Initialize the array with some values
    for (int i = 0; i < 1000; i++) {
        array[i] = i;
    }

    for (int i = 0; i < 1000; i++) {
        // Simple loop body
        sum += array[i];
    }

    printf("Sum: %d\n", sum);

    return 0;
}