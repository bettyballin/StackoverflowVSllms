pp
#include <iostream>

void NameOfFunction(long param1, double& param2) {
    // Example function body
    param2 = param1 * 2.0;
}

int main() {
    double d = 0.0;
    NameOfFunction(5L, d);
    std::cout << "Result: " << d << std::endl;
    return 0;
}