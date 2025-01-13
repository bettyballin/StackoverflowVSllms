#include <fstream>\n#include <iostream>\n#include <string>\n\nint main() {\n    std::ifstream file("example.txt");\n    if (!file.is_open()) {\n        std::cerr << "Failed to open file" << std::endl;\n        return 1;\n    }\n\n    std::string token;\n    char c;\n    while (file.get(c)) {\n        if (c == '\n') {\n            std::cout << "[NEW LINE]" << std::endl;\n        } else if (c == ' ') {\n            if (!token.empty()) {\n                std::cout << token << std::endl;\n                token.clear();\n            }\n        } else {\n            token += c;\n        }\n    }\n\n    if (!token.empty()) {\n        std::cout << token << std::endl;\n    }\n\n    file.close();\n    return 0;\n}