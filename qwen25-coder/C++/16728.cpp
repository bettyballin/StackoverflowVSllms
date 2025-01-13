#include <ctime>\n#include <iostream>\n\nvoid someFunction() {\n    // Simulate some operations\n    for (int i = 0; i < 1000; ++i) {\n        // Dummy operation\n    }\n}\n\nint main() {\n    std::clock_t start = std::clock();\n    \n    someFunction();\n    \n    std::clock_t end = std::clock();\n    double duration = static_cast<double>(end - start) / CLOCKS_PER_SEC;\n    \n    std::cout << "Duration: " << duration << " seconds\n";\n    return 0;\n}