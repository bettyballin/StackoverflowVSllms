pp
#include <iostream>
#include <functional> // For std::function, which is more versatile

// Define a simple unary function template
template <typename SomeType, typename ReturnType>
using unary_function = std::function<ReturnType(SomeType)>;

int main() {
    // Example usage: Define a unary function that takes an int and returns a bool
    unary_function<int, bool> isPositive = [](int value) { return value > 0; };

    // Use the unary function
    std::cout << std::boolalpha << isPositive(5) << std::endl;  // Should print: true
    std::cout << std::boolalpha << isPositive(-3) << std::endl; // Should print: false

    return 0;
}