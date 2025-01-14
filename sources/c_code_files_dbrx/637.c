#include <stdio.h>

int calculate_midpoint(int low, int high) {
    int mid = (low + high) >> 1;
    return mid;
}

int main() {
    int low = 10;
    int high = 20;
    int mid = calculate_midpoint(low, high);
    printf("Midpoint: %d\n", mid);
    return 0;
}