#include <stdio.h>

void increment(int *ptr) {
    ++(*ptr);
}

int main() {
    int x = 10;
    increment(&x);
    printf("Now, the value of 'x' is %d\n", x);
    return 0;
}