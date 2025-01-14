pp
#include <iostream>

template<class T>
struct Foo {
  T val_;
  Foo(T val) : val_(val) {
      // heavy code, long compile times
  }
};

int main() {
    Foo<int> foo(5);
    std::cout << foo.val_ << std::endl;
    return 0;
}