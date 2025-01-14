pp
#include <memory>

class MyClass {
public:
    MyClass() { }
    ~MyClass() { }
};

int main() {
    std::auto_ptr<MyClass> ptr(new MyClass());
    return 0;
}