pp
#include <iostream>

template <class T> struct A {
    void f(int);
    template <class T2> void f(T2);
};

template <class T> void A<T>::f(int) { std::cout << "Non-template" << std::endl; }

template <class T> template <class T2> void A<T>::f(T2) { std::cout << "Template" << std::endl; }

template <> void A<int>::f(int) { std::cout << "Specialized non-template" << std::endl; }

template <> template <> void A<int>::f<>(int) { std::cout << "Specialized template" << std::endl; }

int main()
{
    A<char> ac;
    ac.f(1); //non-template
    ac.f('c'); //template
    ac.f<>(1); //template
    return 0;
}