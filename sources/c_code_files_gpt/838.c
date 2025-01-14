#include <stdio.h>

void compute(int *array, int size) {
    for (int i = 0; i < size; ++i) {
        array[i] = array[i] * 2;
    }
}

int main() {
    int array[64]; // Small array to fit in cache
    for (int i = 0; i < 64; ++i) {
        array[i] = i;
    }

    compute(array, 64);

    for (int i = 0; i < 64; ++i) {
        printf("%d ", array[i]);
    }

    return 0;
}