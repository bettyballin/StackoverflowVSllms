pp
// This is C++ code, not C code
#include <iostream>

struct Base {
};

struct C1 : Base {
    int i;
};

struct C2 : Base {
    C1 c;
    int i;
};

int main() {
    // Example usage
    C2 obj;
    obj.i = 10;
    obj.c.i = 20;

    std::cout << "obj.i: " << obj.i << std::endl;
    std::cout << "obj.c.i: " << obj.c.i << std::endl;

    return 0;
}