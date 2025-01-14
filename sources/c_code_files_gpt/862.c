#include <stdio.h>

struct foo {
    int k;
};

int ret_foo(const struct foo* f) {
    return f->k;
}

int main() {
    struct foo f;
    f.k = 10; // Assign some value to demonstrate
    printf("Value of k: %d\n", ret_foo(&f));
    return 0;
}