pp
#include <iostream>

class Thing {
public:
    int value;

    Thing(int val) : value(val) {}
};

class CustomComparator {
public:
    bool operator()(Thing& start, Thing& end) {
        // comparison logic goes here
        return start.value < end.value;
    }
};

int main() {
    Thing a(5);
    Thing b(10);

    CustomComparator comparator;
    std::cout << std::boolalpha << comparator(a, b) << std::endl;

    return 0;
}