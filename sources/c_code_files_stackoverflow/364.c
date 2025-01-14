#include <stdio.h>

struct B {
    int m;
    int n;
    int (*f)(void);
    int (*g)(void);
};

int n;
int g(void) {
    return 0;
}

struct C {
    struct B base;
};

void h(struct C* self) {
    self->base.m = 0;
    self->base.f = NULL; // initialize to NULL
    self->base.n = 0;
    g(); // call the global g function
}

int main() {
    struct C c;
    h(&c);
    return 0;
}