++
#include <iostream>
using std::cout;

class A { public: int x; };
class B { public: int y; };
class C : public B, public A { public: void foo(){ cout << "a.x == " << x << std::endl;}};

int main() {
    typedef void (C::*pmf_t)();
    C c; c.x = 42; c.y = -1;

    pmf_t mf = static_cast<pmf_t>(&C::foo);
    (c.*mf)();
}