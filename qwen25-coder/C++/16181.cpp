#include <iostream>\n#include <memory> // for std::unique_ptr\n\nvoid someFunction() {\n    // Using unique_ptr for automatic memory management\n    std::unique_ptr<int> ptr = std::make_unique<int>(10);\n    // No need to manually delete the pointer\n}\n\nint main() {\n    someFunction();\n    return 0;\n}