pp
#include <iostream>

template <typename T>
class myclass {
public:
    myclass(T value) : value_(value) {}
    void print() { std::cout << value_ << std::endl; }

private:
    T value_;
};

// Instantiate myclass for the supported template type parameters
template class myclass<int>;
template class myclass<long>;

int main() {
    myclass<int> obj1(5);
    myclass<long> obj2(10L);

    obj1.print();
    obj2.print();

    return 0;
}