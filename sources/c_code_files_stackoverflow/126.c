pp
#include <vector>

class Base { 
public:
  virtual ~Base(){}
  virtual void DoSomething() = 0;
};

template <class T> class MyClass : public Base {
public:
    void DoSomething(){}
};

int main() {
    std::vector<Base *> objects;
    objects.push_back(new MyClass<int>);
    objects.push_back(new MyClass<char>);
    return 0;
}