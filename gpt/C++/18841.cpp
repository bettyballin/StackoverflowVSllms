#include <iostream>\n#include <chrono>\n#include <thread>\n\nvoid Blah() {\n    // Simulate some work\n    std::this_thread::sleep_for(std::chrono::milliseconds(1));\n}\n\nint main() {\n    auto start = std::chrono::high_resolution_clock::now();\n\n    while (true) {\n        Blah();\n\n        auto now = std::chrono::high_resolution_clock::now();\n        auto elapsed = std::chrono::duration_cast<std::chrono::milliseconds>(now - start);\n\n        if (elapsed.count() > 30) {\n            break;\n        }\n    }\n\n    std::cout << "Exited loop after " << std::chrono::duration_cast<std::chrono::milliseconds>(std::chrono::high_resolution_clock::now() - start).count() << " ms" << std::endl;\n    return 0;\n}