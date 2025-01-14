++
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <cctype>

bool starts_with(const std::string &s1, const std::string &s2) {
    return (s1.length() <= s2.length()) && (s2.substr(0, s1.length()) == s1);
}

bool ends_with(const std::string &s1, const std::string &s2) {
    return (s1.length() <= s2.length()) && (s2.substr(s2.length() - s1.length()) == s1);
}

bool is_numeric(const std::string &s) {
    for(std::string::const_iterator it = s.begin(); it != s.end(); ++it) {
        if(!std::isdigit(*it)) {
                return false;
        }
    }
    return true;
}

bool varies_in_single_number_field(std::string s1, std::string s2) {

    size_t index1 = 0;
    size_t index2 = s1.length() - 1;

    if(s1 == s2) {
        return false;
    }

    if((s1.empty() && is_numeric(s2)) || (s2.empty() && is_numeric(s1))) {
        return true;
    }

    if(s1.length() < s2.length()) {
        s1.swap(s2);
    }

    while(index1 < s1.length() && starts_with(s1.substr(0, index1), s2)) { index1++; }
    while(ends_with(s1.substr(index2), s2)) { index2--; }

    return is_numeric(s1.substr(index1 - 1, (index2 + 1) - (index1 - 1)));

}

int main() {
    std::cout << std::boolalpha << varies_in_single_number_field("foo7bar00", "foo123bar00") << std::endl;
    std::cout << std::boolalpha << varies_in_single_number_field("foo7bar00", "foo123bar01") << std::endl;
    std::cout << std::boolalpha << varies_in_single_number_field("foobar00", "foo123bar00") << std::endl;
    std::cout << std::boolalpha << varies_in_single_number_field("foobar00", "foobar00") << std::endl;
    std::cout << std::boolalpha << varies_in_single_number_field("7aaa", "aaa") << std::endl;
    std::cout << std::boolalpha << varies_in_single_number_field("aaa7", "aaa") << std::endl;
    std::cout << std::boolalpha << varies_in_single_number_field("aaa", "7aaa") << std::endl;
    std::cout << std::boolalpha << varies_in_single_number_field("aaa", "aaa7") << std::endl;
}