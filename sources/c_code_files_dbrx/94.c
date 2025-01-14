#include <stdio.h>

enum Foo { BAR, BAZ };

// Function declaration
enum Foo testFunc(void);

// Function definition
enum Foo testFunc(void) {
    return BAR;
}

int main() {
    enum Foo result = testFunc();
    printf("Result: %d\n", result);
    return 0;
}