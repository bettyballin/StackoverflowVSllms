#include <iostream>\n#include "CFun.hpp"\n\nvoid hello(const CFun& obj) {\n    std::cout << "hello" << std::endl;\n}\n\nint main() {\n    CFun myObj;\n    hello(myObj);  // Call the standalone function\n    return 0;\n}