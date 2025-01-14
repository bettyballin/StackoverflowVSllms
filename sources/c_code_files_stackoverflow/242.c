#include <stdexcept>

class SomeClass {
public:
    void function1(...) {
        /* ... */
        throw std::runtime_error("The foo blortched the baz!");
        /* ... */
    }
};

int main() {
    try {
        SomeClass obj;
        obj.function1(...);
    } catch (const std::exception& e) {
        // handle the exception
    }
    return 0;
}