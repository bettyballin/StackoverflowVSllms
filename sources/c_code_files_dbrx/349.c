#include <stdio.h>

void testPassRef(int* ref) {
    (*ref)++;
    printf("Value after increment: %d\n", *ref);
}

int main() {
    int value = 5;
    printf("Original value: %d\n", value);
    testPassRef(&value);
    printf("Final value: %d\n", value);
    return 0;
}