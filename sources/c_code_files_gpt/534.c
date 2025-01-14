#include <stdio.h>

int main() {
    int low = 0;
    int high = 10;
    int mid = low + ((high - low) >> 1);
    printf("%d\n", mid);
    return 0;
}