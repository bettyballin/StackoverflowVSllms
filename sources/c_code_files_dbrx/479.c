#include <stdio.h>

void swap(int *restrict aptr, int *restrict bptr) {
    int tmp = *aptr;
    *aptr = *bptr;
    *bptr = tmp;
}

int main() {
    int a = 5;
    int b = 10;

    printf("Before swap: a = %d, b = %d\n", a, b);

    swap(&a, &b);

    printf("After swap: a = %d, b = %d\n", a, b);

    return 0;
}