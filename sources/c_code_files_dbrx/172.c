#include <stdio.h>

struct Foobar {
    int foo;
    int bar;
};

__attribute__ ((section ("foobar"))) struct Foobar foobar;

int main() {
    return 0;
}