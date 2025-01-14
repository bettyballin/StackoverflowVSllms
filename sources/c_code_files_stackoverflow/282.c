pp
// foo.h (header file)
#ifndef FOO_H
#define FOO_H

class Foo {
public:
    void foo(int b);
};

#endif  // FOO_H

// foo.cpp (source file)
#include "foo.h"

void Foo::foo(const int b) {
    // Stuff
}

int main() {
    Foo f;
    f.foo(42);
    return 0;
}