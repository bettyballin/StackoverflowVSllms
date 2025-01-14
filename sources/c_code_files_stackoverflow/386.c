#include <stdio.h>

extern void foo1(int x, int y, int z, int a) __attribute__((fastcall));
extern void foo2(int x, int y, int z, int a);

void foo1(int x, int y, int z, int a) {
    printf("foo1 called with: %d, %d, %d, %d\n", x, y, z, a);
}

void foo2(int x, int y, int z, int a) {
    printf("foo2 called with: %d, %d, %d, %d\n", x, y, z, a);
}

void bar1() {
    foo1(99, 100, 101, 102);
}

void bar2() {
    foo2(89, 90, 91, 92);
}

int main() {
    bar1();
    bar2();
    return 0;
}