#include <iostream>\n#include <vector>\n\nint main() {\n    std::vector<char> safeBuffer(5);\n    std::cin.getline(safeBuffer.data(), safeBuffer.size());\n    for (char c : safeBuffer) {\n        std::cout << c;\n    }\n    return 0;\n}