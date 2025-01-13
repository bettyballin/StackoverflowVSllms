#include <iostream>\n#include <stdexcept>\n#include <string>\n#include <vector>\n#include <cstdio>\n\nstd::string exec(const char* cmd) {\n    std::string result;\n    FILE* pipe = popen(cmd, "r");\n    if (!pipe) throw std::runtime_error("popen() failed!");\n    try {\n        char buffer[128];\n        while (fgets(buffer, 128, pipe) != NULL)\n            result += buffer;\n    } catch (...) {\n        pclose(pipe);\n        throw;\n    }\n    pclose(pipe);\n    return result;\n}\n\nint main() {\n    std::string cmd = "./some_command";\n    std::string result = exec(cmd.c_str());\n    std::cout << "Result: " << result << std::endl;\n    return 0;\n}