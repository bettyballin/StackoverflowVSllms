#include <stdio.h>

#define ARRAY_LEN 10

int main() {
    printf("Size of long multiplied by ARRAY_LEN: %zu\n", sizeof (long) * ARRAY_LEN);
    return 0;
}