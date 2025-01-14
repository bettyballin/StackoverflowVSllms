#include <iostream>
#include <vector>
#include <string>

std::vector<std::string> explode(const std::string& str, const char& ch) {
    std::string next;
    std::vector<std::string> result;

    // For each character in the string
    for (std::string::const_iterator it = str.begin(); it != str.end(); it++) {
        // If we've hit the terminal character
        if (*it == ch) {
            // If we have some characters accumulated
            if (!next.empty()) {
                // Add them to the result vector
                result.push_back(next);
                next.clear();
            }
        } else {
            // Accumulate the next character into the sequence
            next += *it;
        }
    }
    if (!next.empty())
         result.push_back(next);
    return result;
}

int main() {
    std::string str = "hello,world,again";
    char ch = ',';
    std::vector<std::string> result = explode(str, ch);
    for (const auto& s : result) {
        std::cout << s << std::endl;
    }
    return 0;
}