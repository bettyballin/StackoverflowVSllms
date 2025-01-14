pp
#include <iostream>
#include <vector>

int main() {
    // Create a vector (similar to a list in other languages)
    std::vector<int> num_list = {1, 2, 3, 4, 5};

    // Create an iterator pointing to the element to be erased
    auto elements_iter = num_list.begin() + 2; // points to the element '3'

    // Print the original list
    std::cout << "Original list: ";
    for (const auto& num : num_list) {
        std::cout << num << " ";
    }
    std::cout << std::endl;

    // Erase the element pointed to by the iterator
    num_list.erase(elements_iter);

    // Print the list after erasing the element
    std::cout << "List after erasing the element: ";
    for (const auto& num : num_list) {
        std::cout << num << " ";
    }
    std::cout << std::endl;

    return 0;
}