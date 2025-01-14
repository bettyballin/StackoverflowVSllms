// foo.h (remains the same)
enum Foo {
    BAR,
    BAZ
};

// Function declaration
enum Foo testFunc(void);

// foo.c (new file)
#include "foo.h"

// Function implementation
enum Foo testFunc(void) {
    return BAR; // Return a value for demonstration purposes
}

int main() {
    enum Foo result = testFunc();
    return 0;
}