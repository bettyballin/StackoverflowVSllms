#include <iostream>\n#include <string>\n#include <sstream>\n\n// method 1: using std::string::operator+\nstd::string concatUsingPlus(std::string str1, std::string str2) {\n    return str1 + str2;\n}\n\n// method 2: using std::stringstream\nstd::string concatUsingStringStream(std::string str1, std::string str2) {\n    std::stringstream ss;\n    ss << str1 << str2;\n    return ss.str();\n}\n\n// method 3: using std::string::append\nstd::string concatUsingAppend(std::string str1, std::string str2) {\n    str1.append(str2);\n    return str1;\n}\n\nint main() {\n    std::string str1 = "Hello";\n    std::string str2 = "World";\n\n    std::cout << concatUsingPlus(str1, str2) << std::endl;\n    std::cout << concatUsingStringStream(str1, str2) << std::endl;\n    std::cout << concatUsingAppend(str1, str2) << std::endl;\n\n    return 0;\n}