#include <iostream>\n#include <fstream>\n#include <sstream>\n#include <string>\n\nstd::string readFileToString(const std::string& filePath) {\n    std::ifstream file(filePath);\n    if (!file.is_open()) {\n        throw std::runtime_error("Could not open file");\n    }\n    return std::string((std::istreambuf_iterator<char>(file)), std::istreambuf_iterator<char>());\n}\n\nint main() {\n    try {\n        std::string text = readFileToString("text.txt");\n        std::cout << text;\n    } catch (const std::exception& e) {\n        std::cerr << "Error: " << e.what() << std::endl;\n    }\n    return 0;\n}