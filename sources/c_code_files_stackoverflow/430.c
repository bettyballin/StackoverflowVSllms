pp
#include <iostream>

template <typename T, int N>
void func(T (&a) [N]) {
    for (int i = 0; i < N; ++i) a[i] = T(); // reset all elements
}

int main() {
    int arr[5] = {1, 2, 3, 4, 5};
    func(arr);
    for (int i = 0; i < 5; ++i) {
        std::cout << arr[i] << " ";
    }
    return 0;
}