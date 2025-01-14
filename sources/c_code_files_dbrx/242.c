#include <stdio.h>

int main() {
    int x = 10; // Assign some value to x
    printf("%p, %d\n", (void*)&x, x); // output depends on compiler and platform
    return 0;
}