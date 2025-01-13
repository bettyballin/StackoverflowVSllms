#include <iostream>\n#include <vector>\n#include <algorithm>\n\nint main() {\n    std::vector<std::vector<int>> v = {{1, 2, 3}, {4, 5}, {6, 7, 8, 9}};\n\n    // Use std::max_element with a custom comparator to find the largest sub-container by size\n    auto largest = std::max_element(v.begin(), v.end(),\n                                  [](const std::vector<int>& a, const std::vector<int>& b) {\n                                      return a.size() < b.size();\n                                  });\n\n    if (largest != v.end()) {\n        std::cout << "The largest sub-container has size: " << largest->size() << std::endl;\n    } else {\n        std::cout << "Container is empty." << std::endl;\n    }\n\n    return 0;\n}