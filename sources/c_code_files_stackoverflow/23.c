#include <vector>

int main() {
    std::vector<int> v(100);
    int* p = &v[0];
    p[3] = 42;
    return 0;
}