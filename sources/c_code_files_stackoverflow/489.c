pp
#include <iostream>

template<typename A, typename B>
class Foo { };

struct Bar {
  void method ( Foo<int,int> const& stuff = Foo<int,int>() ) {
    // Method implementation
  }
};

int main() {
  Bar bar;
  bar.method();
  return 0;
}