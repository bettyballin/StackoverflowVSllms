pp
#include <vector>
#include <iostream>

int main() {
    // Example vector of integers
    std::vector<int> v = {1, 2, 3, 4, 5};
    
    // Using auto for simplicity, which is the modern C++ way to declare iterators
    auto i = v.begin();
    
    // Example usage: printing the first element
    std::cout << "First element: " << *i << std::endl;
    
    return 0;
}