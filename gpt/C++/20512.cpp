#include <iostream>\n#include <vector>\n#include <unordered_map>\n\nint main() {\n    std::vector<int> a = {2, 456, 34, 3456, 2, 435, 2, 456, 2};\n\n    std::unordered_map<int, int> frequency;\n\n    // Count the frequency of each element\n    for (int num : a) {\n        frequency[num]++;\n    }\n\n    // Find the element with the maximum frequency\n    int max_count = 0;\n    int most_frequent = -1;\n    for (const auto& pair : frequency) {\n        if (pair.second > max_count) {\n            max_count = pair.second;\n            most_frequent = pair.first;\n        }\n    }\n\n    std::cout << "The number with the maximum frequency is " << most_frequent \n              << " with a count of " << max_count << "." << std::endl;\n\n    return 0;\n}