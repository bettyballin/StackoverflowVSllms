pp
#include <iostream>

template<typename T>
class Functor {
  T f;
public:
  Functor(T t){
      f = t;
  }
  T& operator()(){
    return f;
  }
};

int add(int a, int b)
{
  return a+b;
}

void testing()
{
  Functor<int (*)(int, int)> f(add);
  std::cout << f()(2,3);
}

int main() {
  testing();
  return 0;
}