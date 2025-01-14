#include <stdio.h>

int main() {
    int value = 11;
    int count = 0;
    while (value > 0) {
        count++;
        value = value >> 1;
    }
    printf("Count: %d\n", count);
    return 0;
}