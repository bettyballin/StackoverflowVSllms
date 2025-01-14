// This is not C code, but rather C++ code. However, we can make it compile with gcc by renaming the file to have a .cpp extension and using g++ instead.

// If you want to keep the code in C, you would need to rewrite the class and methods to use C syntax, which would be quite different. Here's an example of how you could do it:

// foo.h
typedef struct Foo Foo;

Foo* Foo_Create();
int Foo_Bar(Foo* pFoo);
void Foo_Delete(Foo* pFoo);

// foo.c
#include "foo.h"
#include <stdlib.h>

typedef struct Foo {
    // Add struct members here if needed
} Foo;

Foo* Foo_Create() {
    return (Foo*) malloc(sizeof(Foo));
}

int Foo_Bar(Foo* pFoo) {
    // Add implementation here
    return 0;
}

void Foo_Delete(Foo* pFoo) {
    free(pFoo);
}

// main.c
#include "foo.h"

int main() {
    Foo* foo = Foo_Create();
    int result = Foo_Bar(foo);
    Foo_Delete(foo);
    return 0;
}

// Compile with: gcc -o main main.c foo.c