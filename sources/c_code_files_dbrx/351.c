#include <stdio.h>

int main() {
    int arr[5] = {1, 2, 3, 4, 5};
    int *ptr = arr;

    // Pointer arithmetic is used here, but correctly within array bounds
    printf("%d\n", *(ptr + 2)); // Should print 3

    return 0;
}