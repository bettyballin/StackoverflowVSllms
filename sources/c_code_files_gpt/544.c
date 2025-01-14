#include <stdio.h>
#include <limits.h>

int main() {
    printf("Size of int: %zu bits\n", sizeof(int) * CHAR_BIT);
    printf("Size of long: %zu bits\n", sizeof(long) * CHAR_BIT);
    printf("Size of pointer: %zu bits\n", sizeof(void*) * CHAR_BIT);

    return 0;
}