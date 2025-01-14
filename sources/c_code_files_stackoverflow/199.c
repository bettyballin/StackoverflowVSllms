pp
#include <iostream>

class Base
{
public:
    virtual ~Base() {} // Virtual destructor
};

template <typename T>
class Foo : public Base
{
public:
    Foo() {}
    ~Foo() {}
};

Base *newBase(bool condition)
{
    if(condition)
        return new Foo<float>();
    else
        return new Foo<double>();
}

int main()
{
    Base *b = newBase(true);
    delete b; // Don't forget to delete dynamically allocated memory
    return 0;
}