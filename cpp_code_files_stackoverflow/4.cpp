#include <iostream>

class Foo
{
    int a;int b;int c;int d;char e;unsigned short int*f;
public:
    Foo(int A,int B,int C,int D,char E,unsigned short int*F) : a(A), b(B), c(C), d(D), e(E), f(F) {}
};

int main() {
    int a = 1, b = 2, c = 3, d = 4;
    char e = 'e';
    unsigned short int f_val = 5;
    unsigned short int* f = &f_val;

    char *buf  = new char[sizeof(Foo)];   //pre-allocated buffer
    Foo *foo = new (buf) Foo(a,b,c,d,e,f);

    // Don't forget to manually call the destructor
    foo->~Foo();

    delete[] buf;

    return 0;
}