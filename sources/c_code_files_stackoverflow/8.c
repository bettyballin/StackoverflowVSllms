pp
#include <iostream>

template <char... Chars>
struct myTemplate {
    static constexpr char value[] = {Chars...};
};

int main() {
    std::cout << myTemplate<'s', 't', 'r', 'i', 'n', 'g'>::value << std::endl;
    return 0;
}