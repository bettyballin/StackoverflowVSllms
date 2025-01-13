#include <iostream>\n#include <fstream>\n#include <string>\n\nint main() {\n    // Writing to a file\n    std::ofstream outFile("example.txt");\n    if (outFile.is_open()) {\n        outFile << "Hello, world!";\n        outFile.close();\n    } else {\n        std::cerr << "Unable to open file for writing." << std::endl;\n    }\n\n    // Reading from a file\n    std::ifstream inFile("example.txt");\n    std::string line;\n    if (inFile.is_open()) {\n        while (getline(inFile, line)) {\n            std::cout << line << std::endl;\n        }\n        inFile.close();\n    } else {\n        std::cerr << "Unable to open file for reading." << std::endl;\n    }\n\n    return 0;\n}