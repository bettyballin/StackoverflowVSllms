#include <iostream>\n#include <string>\n\nvoid generateSubstringsIteratively(const std::string& s) {\n    int n = s.size();\n    int totalCombinations = 1 << n; // 2^n combinations\n\n    for (int i = 0; i < totalCombinations; ++i) {\n        std::string current;\n        bool isValid = true;\n\n        for (int j = 0; j < n; ++j) {\n            if (i & (1 << j)) { // Check if the j-th bit in i is set\n                if (!current.empty() && s[j] < current.back()) {\n                    isValid = false;\n                    break;\n                }\n                current += s[j];\n            }\n        }\n\n        if (isValid && !current.empty()) {\n            std::cout << current << std::endl;\n        }\n    }\n}\n\nint main() {\n    std::string input = "aaacdddghzz";\n    generateSubstringsIteratively(input);\n    return 0;\n}