#include <iostream>\n#include <vector>\n\nint main() {\n    int target = 100;\n    std::vector<int> dp(target + 1, 0);\n    dp[0] = 1; // Base case\n\n    for (int i = 1; i <= target; ++i) {\n        for (int j = 1; j <= i; ++j) {\n            dp[i] += dp[i - j];\n        }\n    }\n\n    std::cout << "Number of ways to write 100 as a sum of at least two positive integers: " << dp[target] - 1 << std::endl;\n    return 0;\n}