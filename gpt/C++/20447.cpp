#include <iostream>\n#include <fstream>\n#include <string>\n\nint main() {\n    std::ifstream fifo("/path/to/fifo");\n\n    if (!fifo) {\n        std::cerr << "Failed to open FIFO" << std::endl;\n        return 1;\n    }\n\n    while (true) {\n        std::string line;\n        if (std::getline(fifo, line)) {\n            std::cout << "Received: " << line << std::endl;\n        } else {\n            // Clear the EOF flag and wait for more data\n            fifo.clear();\n            std::this_thread::sleep_for(std::chrono::milliseconds(100));\n        }\n    }\n\n    return 0;\n}