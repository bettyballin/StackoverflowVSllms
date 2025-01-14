#include <stdio.h>

int main() {
    int i = 0;

    // Before optimization
    i = i + 1;
    i = i + 1;

    printf("Before optimization: i = %d\n", i);

    i = 0; // Reset i

    // After peephole optimization
    i = i + 2;

    printf("After optimization: i = %d\n", i);

    return 0;
}