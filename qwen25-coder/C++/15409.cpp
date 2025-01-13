#include <iostream>\n#include <cstdio>\n#include <string>\n\nstd::string exec(const char* cmd) {\n    std::array<char, 128> buffer;\n    std::string result;\n    std::unique_ptr<FILE, decltype(&pclose)> pipe(popen(cmd, "r"), pclose);\n    if (!pipe) {\n        throw std::runtime_error("popen() failed!");\n    }\n    while (fgets(buffer.data(), buffer.size(), pipe.get()) != nullptr) {\n        result += buffer.data();\n    }\n    return result;\n}\n\nint main() {\n    try {\n        std::string output = exec("./some_command");\n        std::cout << "Output:\n" << output;\n    } catch (const std::exception& e) {\n        std::cerr << "Error: " << e.what() << '\n';\n    }\n    return 0;\n}