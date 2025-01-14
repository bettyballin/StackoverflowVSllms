#include <stdio.h>

int main() {
    int array[1000];
    int sum = 0;

    // Initialize array with some values (e.g., 1 to 1000)
    for (int i = 0; i < 1000; i++) {
        array[i] = i + 1;
    }

    // Original code
    for (int i = 0; i < 1000; i += 4) {
        sum += array[i];
        sum += array[i + 1];
        sum += array[i + 2];
        sum += array[i + 3];
    }

    printf("Sum: %d\n", sum);

    return 0;
}