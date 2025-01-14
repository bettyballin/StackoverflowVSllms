pp
#include <boost/pending/fibonacci_heap.hpp>
#include <iostream>

int main() {
    // Create a Fibonacci heap
    boost::fibonacci_heap<int> heap;

    // Push some values onto the heap
    heap.push(10);
    heap.push(20);
    heap.push(15);

    // Print the top value (minimum)
    std::cout << "Top value: " << heap.top() << std::endl;

    // Pop the top value
    heap.pop();

    // Print the top value again
    std::cout << "Top value after pop: " << heap.top() << std::endl;

    return 0;
}