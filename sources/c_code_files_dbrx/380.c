#include <stdio.h>

// Define struct A with a size of 1 byte
struct A {
    char a;
};

// Define struct B with a size of 4 bytes (assuming int is 4 bytes)
struct B {
    int b;
};

int main() {
    printf("Size of struct A: %zu\n", sizeof(struct A));
    printf("Size of struct B: %zu\n", sizeof(struct B));
    return 0;
}