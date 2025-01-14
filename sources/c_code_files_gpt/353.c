#include <stdio.h>

struct ExampleAligned {
    char a;
    int b;
    char c;
    short d;
} __attribute__((aligned(8)));

int main() {
    struct ExampleAligned example;
    example.a = 'a';
    example.b = 1;
    example.c = 'c';
    example.d = 2;

    printf("Size of struct: %zu\n", sizeof(struct ExampleAligned));
    printf("Address of a: %p\n", (void*)&example.a);
    printf("Address of b: %p\n", (void*)&example.b);
    printf("Address of c: %p\n", (void*)&example.c);
    printf("Address of d: %p\n", (void*)&example.d);

    return 0;
}