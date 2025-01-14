#include <stdio.h>

int main() {
    int x;
    for (x = 0; x < 100; x++) {
        if (x * 31 == (x << 5) - x) {
            printf("True for x = %d\n", x);
        }
    }
    return 0;
}