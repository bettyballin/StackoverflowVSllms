template<class T>\nstruct Foo {\n  T val_;\n  Foo(T val) : val_(val) {\n      // heavy code, long compile times\n  }\n};