#include <iostream>

template <typename MC, typename MT>
struct Factory {
    template <typename T>
    static void Register(MT Type) {
        // Your registration logic here
        std::cout << "Registered type: " << typeid(T).name() << std::endl;
    }
};

int main() {
    auto result = Factory<int, const char*>::template Register<int>("IntType");
    return 0;
}