#include <iostream>

namespace nsB {
    void foo() { std::cout << "nsB\n";}
}

namespace nsA {
    void foo() { std::cout << "nsA\n";}
    namespace subA {
        void foo() { std::cout << "nsA::subA\n";}
        void bar() {
            nsB::foo();
        }
    }
}

int main() {
    nsA::subA::bar();
    return 0;
}