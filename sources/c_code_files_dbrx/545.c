#include <stdio.h>

void update(int *restrict p1, int *p2) {
    //...
}

void do_something() {
    int arr[5]; /* Assume this array is initialized somewhere */
    update(arr, arr + 3);   /* Fixed the incompatible pointers issue */
}

int main() {
    do_something();
    return 0;
}