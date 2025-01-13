#include <vector>\n#include <algorithm>\n#include <iostream>\n\nint main() {\n    using std::vector;\n    vector<int> numbers;\n    for (int i = -10; i <= 10; ++i) {\n        numbers.push_back(i);\n    }\n\n    vector<int> positive_numbers;\n    std::copy_if(numbers.begin(), numbers.end(), std::back_inserter(positive_numbers), [](int num) {\n        return num > 0;\n    });\n\n    // Output the positive numbers\n    for (int num : positive_numbers) {\n        std::cout << num << " ";\n    }\n    std::cout << std::endl;\n\n    return 0;\n}