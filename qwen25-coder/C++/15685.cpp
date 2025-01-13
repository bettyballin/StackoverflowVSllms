#include <iostream>\n#include <fstream>\n\nint main(int argc, char* argv[]) {\n    if (argc > 1) {\n        std::ifstream file(argv[1]);\n        if (!file.is_open()) {\n            std::cerr << "Failed to open file: " << argv[1] << std::endl;\n            return 1;\n        }\n        // Process the file\n        std::cout << "File opened successfully." << std::endl;\n        std::string line;\n        while (getline(file, line)) {\n            std::cout << line << std::endl;\n        }\n    } else {\n        std::cerr << "No file provided." << std::endl;\n    }\n    return 0;\n}