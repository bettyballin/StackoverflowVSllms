++
#include <iostream>

template <typename T>
void say_hello(const T& t) {
  t.hello();
}

class Greeter {
public:
  void hello() {
    std::cout << "Hello!" << std::endl;
  }
};

int main() {
  Greeter g;
  say_hello(g);
  return 0;
}