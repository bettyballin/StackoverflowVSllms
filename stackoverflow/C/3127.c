#include <iostream>\n#include <string>\n#include <vector>\n#include <algorithm>\n#include <cctype>\n\nbool starts_with(const std::string &s1, const std::string &s2) {\n    return (s1.length() <= s2.length()) && (s2.substr(0, s1.length()) == s1);\n}\n\nbool ends_with(const std::string &s1, const std::string &s2) {\n    return (s1.length() <= s2.length()) && (s2.substr(s2.length() - s1.length()) == s1);\n}\n\nbool is_numeric(const std::string &s) {\n    for(std::string::const_iterator it = s.begin(); it != s.end(); ++it) {\n        if(!std::isdigit(*it)) {\n                return false;\n        }\n    }\n    return true;\n}\n\nbool varies_in_single_number_field(std::string s1, std::string s2) {\n\n    size_t index1 = 0;\n    size_t index2 = s1.length() - 1;\n\n    if(s1 == s2) {\n        return false;\n    }\n\n    if((s1.empty() && is_numeric(s2)) || (s2.empty() && is_numeric(s1))) {\n        return true;\n    }\n\n    if(s1.length() < s2.length()) {\n        s1.swap(s2);\n    }\n\n    while(index1 < s1.length() && starts_with(s1.substr(0, index1), s2)) { index1++; }\n    while(ends_with(s1.substr(index2), s2)) { index2--; }\n\n    return is_numeric(s1.substr(index1 - 1, (index2 + 1) - (index1 - 1)));\n\n}\n\nint main() {\n    std::cout << std::boolalpha << varies_in_single_number_field("foo7bar00", "foo123bar00") << std::endl;\n    std::cout << std::boolalpha << varies_in_single_number_field("foo7bar00", "foo123bar01") << std::endl;\n    std::cout << std::boolalpha << varies_in_single_number_field("foobar00", "foo123bar00") << std::endl;\n    std::cout << std::boolalpha << varies_in_single_number_field("foobar00", "foobar00") << std::endl;\n    std::cout << std::boolalpha << varies_in_single_number_field("7aaa", "aaa") << std::endl;\n    std::cout << std::boolalpha << varies_in_single_number_field("aaa7", "aaa") << std::endl;\n    std::cout << std::boolalpha << varies_in_single_number_field("aaa", "7aaa") << std::endl;\n    std::cout << std::boolalpha << varies_in_single_number_field("aaa", "aaa7") << std::endl;\n}