#include <iostream>

class Foo {
}; // Define Foo class

struct f1 {
  f1(Foo& foo) : foo(foo) {} // pre-function, if you need it
  void operator()(){} // main function
  ~f1() {} // post-function

private:
  Foo& foo;
};

int main() {
  Foo foo;
  f1 func(foo);
  func();
  return 0;
}