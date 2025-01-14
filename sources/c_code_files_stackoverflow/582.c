#include <stdio.h>

typedef struct {
    int a;
    int b;
    int c;
    int d;
    int e;
    int f;
} Foo;

int main() {
    Foo foo;
    foo.a = 1;
    foo.b = 2;
    foo.c = 3;
    foo.d = 4;
    foo.e = 5;
    foo.f = 6;
    
    printf("a = %d, b = %d, c = %d, d = %d, e = %d, f = %d\n",
           foo.a, foo.b, foo.c, foo.d, foo.e, foo.f);
    
    return 0;
}