#include <string>\n#include <vector>\n#include <iostream>\n#include <fstream>\n#include <sstream>\n#include <iterator>\n#include <algorithm>\n\nint main() {\n    std::ifstream file("path/to/your/textfile.txt");\n    if (!file.is_open()) {\n        std::cerr << "Unable to open file" << std::endl;\n        return 1;\n    }\n\n    std::vector<std::string> results;\n    std::string line;\n\n    while (std::getline(file, line)) {\n        std::stringstream strstr(line);\n        std::istream_iterator<std::string> it(strstr);\n        std::istream_iterator<std::string> end;\n        std::copy(it, end, std::back_inserter(results));\n    }\n\n    file.close();\n\n    for (const auto& word : results) {\n        std::cout << word << std::endl;\n    }\n\n    return 0;\n}