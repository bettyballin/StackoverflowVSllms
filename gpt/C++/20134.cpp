#include <iostream>\n#include <stdexcept>\n\n#define CUSTOM_ASSERT(condition, message) \\n    do { \\n        if (!(condition)) { \\n            std::cerr << "Assertion `" #condition "` failed: " << message << std::endl; \\n            std::terminate(); \\n        } \\n    } while (false)\n\nint main() {\n    int num = -1;\n    CUSTOM_ASSERT(num > 0, "The number must be greater than zero!");\n    return 0;\n}