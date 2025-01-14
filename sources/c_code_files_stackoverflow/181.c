pp
#include <iostream>

template <class T>
void bar(T* ptr);

class MyClass  // note that this isn't a template class
{
private:
    void foo();

    template <class T>
    friend void bar(T*);  // ERROR: compiler gives me all kinds of grief
};

void MyClass::foo()
{
    std::cout << "fooed!" << std::endl;
}

template <class T>
void bar(T* ptr)
{
    if (ptr)
    {
        MyClass obj;

        obj.foo();
    }
}

int main(int argc, char* argv[])
{

    int someObj = 1;
    bar(&someObj);

    return 0;
}