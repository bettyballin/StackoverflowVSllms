pp
#include <iostream>

template <typename T>
struct Outer {
    template <typename U = T>
    struct Nested {
        U value;
    };
};

int main() {
    Outer<int>::Nested<> nested;
    nested.value = 5;
    std::cout << nested.value << std::endl;
    return 0;
}