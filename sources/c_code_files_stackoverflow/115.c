#include <iterator>
#include <iostream>
#include <sstream>
#include <vector>
#include <algorithm>

int main() {
    std::vector<std::string> v;

    // ... (assuming some code to populate the vector v)

    std::stringstream ss;
    std::copy(v.begin(), v.end(), std::ostream_iterator<std::string>(ss, " "));
    std::string result = ss.str();
    if (!result.empty()) {
        result.resize(result.length() - 1); // trim trailing space
    }
    std::cout << result << std::endl;

    return 0;
}