pp
#include <iostream>

template<typename T> struct c1 { 
    void foo() { std::cout << "empty" << std::endl; } 
}; 

template<typename T> struct c2 : c1<T> { 
    using c1<T>::foo; 
    void foo(int) { std::cout << "int" << std::endl; } 
}; 

int main() { 
    c2<void> c;
    c.foo();
    c.foo(10); 
    return 0;
}