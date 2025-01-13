#include <iostream>\n#include <vector>\n#include <algorithm>\n\nvoid subarray(const double a, const double b, const std::vector<double> &data, std::vector<double> &sub) {\n    auto lower = std::lower_bound(data.begin(), data.end(), a);\n    auto upper = std::upper_bound(data.begin(), data.end(), b);\n\n    for (auto it = lower; it != upper; ++it) {\n        sub.push_back(*it);\n    }\n}\n\nint main() {\n    std::vector<double> x = {1.1, 1.5, 2.2, 3.3, 4.4, 5.5}; // Example data, sorted\n    std::vector<double> sub;\n    double a = 1.5, b = 4.4; // Example range\n\n    subarray(a, b, x, sub);\n\n    for (double val : sub) {\n        std::cout << val << " ";\n    }\n\n    return 0;\n}