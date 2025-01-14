#include <stdio.h>

// function declaration with extern (explicit)
extern int f();
int f() { return 0; }

// function declaration without extern (implicit)
int g();
int g() { return 1; }

int main() {
    printf("%d\n", f());
    printf("%d\n", g());
    return 0;
}