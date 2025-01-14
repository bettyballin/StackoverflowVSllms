#include <stdio.h>

typedef struct C {
    int dummy;  // Add some content to the struct
} C;

typedef struct B {
    C *c;
} B;

typedef struct A {
    B *b;
} A;

int main() {
    // Initialize the structs
    C c;
    B b = {&c};
    A a = {&b};

    // The original code snippet
    if (a.b && a.b->c) {
        printf("Condition met\n");
    } else {
        printf("Condition not met\n");
    }

    return 0;
}