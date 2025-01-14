pp
#include <iostream>

class CFun {
    // You need to define what CFun is
};

void Hello(CFun &fun) {
    std::cout << "hello" << std::endl;
}

int main() {
    CFun fun;
    Hello(fun);
    return 0;
}