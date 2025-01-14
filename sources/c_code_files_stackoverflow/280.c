pp
#include <functional>
#include <iostream>

class A {
public:
   void doSomething( std::function< void ( int ) > callback )
   {
      callback( 5 );
   }
};

void callbackFunction(int value) {
    std::cout << "Callback called with value: " << value << std::endl;
}

int main() {
    A a;
    a.doSomething(callbackFunction);
    return 0;
}