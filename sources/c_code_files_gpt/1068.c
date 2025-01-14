#include <stdio.h>
// Assuming "mylib.h" is not necessary for this minimal example, it's commented out.
// #include "mylib.h"

int testlib(void) {
    printf("Hello, World!\n");
    return (0);
}

int main() {
    return testlib();
}