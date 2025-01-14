#include <stdio.h>

void foo(int x, int y) {
    printf("x = %d, y = %d\n", x, y);
}

void foo_default(int y) {
    foo(2, y);
}

int main() {
    foo(1, 2); // calls foo with x = 1 and y = 2
    foo_default(3); // calls foo with x = 2 and y = 3
    return 0;
}