class Foo\n{\n    int a;int b;int c;int d;char e;unsigned short int*f;\npublic:\n    Foo(int A,int B,int C,int D,char E,unsigned short int*F) : a(A), b(B), c(C), d(D), e(E), f(F) {}\n};\n\n...\nchar *buf  = new char[sizeof(Foo)];   //pre-allocated buffer\nFoo *f = new (buf) Foo(a,b,c,d,e,f);