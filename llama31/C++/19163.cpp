#include <iostream>\n#include <iomanip>\n\nint main() {\n    std::string var1 = "Test";\n    int var2 = 1;\n\n    std::cout << std::left << std::setw(20) << var1 << var2 << std::endl;\n\n    var1 = "Test2";\n    var2 = 2;\n\n    std::cout << std::left << std::setw(20) << var1 << var2 << std::endl;\n\n    var1 = "Iamlongverylongblah";\n    var2 = 2;\n\n    std::cout << std::left << std::setw(20) << var1 << var2 << std::endl;\n\n    var1 = "Etc";\n    var2 = 1;\n\n    std::cout << std::left << std::setw(20) << var1 << var2 << std::endl;\n\n    return 0;\n}