#include <stdio.h>

int main() {
    int result = 100 | (200 ^ (300 & 400));
    printf("%d\n", result);
    return 0;
}