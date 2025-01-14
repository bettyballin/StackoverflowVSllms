#include <stdio.h>

void foo(int bar) {
    printf("The value of bar is: %d\n", bar);
}

int main() {
    int baz = 10;  // Define baz and assign it a value
    foo(baz);      // Call foo with baz as the argument
    return 0;
}