pp
#include <iostream>

class A {
public:
    virtual ~A() {
        count--;
        if (count == 0) {
            std::cout << "This is the last one, do something." << std::endl;
        }
    }
protected:
    static int count;
};

int A::count = 0;

class B : public A {
public:
    B() {
        count++;
    }
};

int main() {
    // Example usage:
    B b1, b2, b3;
    return 0;
}