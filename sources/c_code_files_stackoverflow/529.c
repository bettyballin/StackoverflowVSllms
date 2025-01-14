pp
#include <iostream>

// Define MyClass to make the code compile
struct MyClass {
    float key;
};

struct MyClassLessThan {
    bool operator()(const MyClass& left, const MyClass& right) {
        return left.key < right.key;
    }
    bool operator()(const MyClass& left, float right) {
        return left.key < right;
    }
    bool operator()(float left, const MyClass& right) {
        return left < right.key;
    }
};

int main() {
    MyClass obj1 = {1.0f};
    MyClass obj2 = {2.0f};

    MyClassLessThan comparator;
    std::cout << std::boolalpha << comparator(obj1, obj2) << std::endl;
    std::cout << std::boolalpha << comparator(obj1, 2.0f) << std::endl;
    std::cout << std::boolalpha << comparator(1.0f, obj2) << std::endl;

    return 0;
}