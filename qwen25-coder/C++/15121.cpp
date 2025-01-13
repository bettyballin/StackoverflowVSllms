#include <iostream>\n\nvoid foo(int x) {\n    std::cout << "int overload\n";\n}\n\nvoid foo(char* ptr) {\n    if (ptr == nullptr) {\n        std::cout << "null pointer\n";\n    } else {\n        std::cout << "non-null pointer\n";\n    }\n}\n\nint main() {\n    char* p = nullptr;\n    foo(p);  // Calls the pointer overload\n    foo(0);    // Calls the int overload (ambiguous in C++98/03, resolved to int in C++11+)\n    return 0;\n}