#include <stdio.h>

#define likely(x)       __builtin_expect(!!(x), 1)
#define unlikely(x)     __builtin_expect(!!(x), 0)

int main() {
    int x = 5;
    if (likely(x > 0)) {
        printf("x is likely greater than 0\n");
    }
    if (unlikely(x < 0)) {
        printf("x is unlikely less than 0\n");
    }
    return 0;
}