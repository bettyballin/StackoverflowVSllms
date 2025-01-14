#include <iostream>
#include <vector>
#include <algorithm>

void out(int x) {
    std::cout << x << ' ';
}

int main() {
    std::vector<int> xs;
    xs.push_back(42);
    xs.push_back(23);

    std::for_each(xs.begin(), xs.end(), out);
    return 0;
}