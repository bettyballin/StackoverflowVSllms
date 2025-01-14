#include <stdbool.h>

typedef struct Foo {
    int value;
} Foo;

bool foo_less_than(const Foo* foo1, const Foo* foo2) {
    return foo1->value < foo2->value;
}