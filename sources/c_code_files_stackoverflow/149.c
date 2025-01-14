pp
#include <string>
#include <iostream>

namespace custom_string_operator {
template <class charT, class traits, class Alloc>
std::basic_string<charT, traits, Alloc>
operator+(const std::basic_string<charT, traits, Alloc>& s1,
          const std::basic_string<charT, traits, Alloc>& s2) {
    std::basic_string<charT, traits, Alloc> result = s1;
    result += s2;
    return result;
}
}

int main() {
    std::string s1 = "Hello";
    std::string s2 = " World";
    std::cout << custom_string_operator::operator+(s1, s2) << std::endl;
    return 0;
}