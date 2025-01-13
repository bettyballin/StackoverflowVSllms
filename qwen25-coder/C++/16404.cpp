#include <iostream>\n#include <vector>\n#include <algorithm>\n\nint main() {\n    std::vector<int> numbers = {1, 2, 3, 4, 5};\n\n    // Hand-rolled loop\n    for (auto& num : numbers) {\n        num *= num;\n    }\n\n    // Using STL algorithm with a lambda function\n    std::transform(numbers.begin(), numbers.end(), numbers.begin(), [](int num) { return num * num; });\n\n    // Output results\n    for (const auto& num : numbers) {\n        std::cout << num << " ";\n    }\n    \n    return 0;\n}