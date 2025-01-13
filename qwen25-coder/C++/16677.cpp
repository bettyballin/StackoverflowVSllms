#include <fstream>\n#include <iostream>\n\nint main() {\n    std::ofstream logFile("C:\\mylog.log", std::ios::app | std::ios::out);\n    if (!logFile.is_open()) {\n        std::cerr << "Failed to open file!" << std::endl;\n        return 1;\n    }\n\n    logFile.setf(std::ios::unitbuf); // Set unbuffered mode\n    logFile << "Hello World!";\n    \n    // Alternatively, use flush explicitly after every write\n    // logFile.flush();\n\n    return 0;\n}