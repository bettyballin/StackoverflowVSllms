#include <stdio.h>

int main() {
    int array[] = {1, 2, 3, 4, 5}; // example array
    int length = sizeof(array) / sizeof(array[0]);

    for (int i = 0; i < length; i++) {
        printf("%d ", array[i]);
    }

    return 0;
}