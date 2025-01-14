#include <stdio.h>

int main() {
    int x = 0;
    printf("%d\n", __sync_add_and_fetch(&x, 4));
    return 0;
}