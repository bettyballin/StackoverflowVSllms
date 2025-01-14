pp
#include <iostream>

class Base {
public:
    virtual void Test() = 0;
};

class A : public Base {
public:
    void Test() {
        std::cout << "A::Test()" << std::endl;
    }
};

class B : public Base {
public:
    void Test() {
        std::cout << "B::Test()" << std::endl;
    }
};

int main(int argc, char* argv[])
{
    int size = 0;
    Base** bases = new Base*[10];

    bases[size++] = new A();
    bases[size++] = new B();

    for (int i = 0; i < size; i++)
    {
        Base* base = bases[i];
        base->Test();
    }

    // Don't forget to delete dynamically allocated memory
    for (int i = 0; i < size; i++)
    {
        delete bases[i];
    }
    delete[] bases;

    return 0;
}