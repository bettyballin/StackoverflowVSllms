++
#include <iostream>

class Abstract {
public:
   virtual void pure_virtual(int x) = 0;
};

void Abstract::pure_virtual(int x) {
   // do something
   std::cout << "Abstract::pure_virtual called with x = " << x << std::endl;
}

class Child : public Abstract {
    virtual void pure_virtual(int x);
};

void Child::pure_virtual(int x) {
    // do something with x
    std::cout << "Child::pure_virtual called with x = " << x << std::endl;
    Abstract::pure_virtual(x); // pass x to the base class method
}

int main() {
    Child child;
    child.pure_virtual(5);
    return 0;
}