#include <iostream>\n#include <fstream>\n#include <vector>\n#include <string>\n#include <sstream>\n\n// Function to split a string based on a delimiter\nstd::vector<std::string> split(const std::string &s, char delim) {\n    std::stringstream ss(s);\n    std::string item;\n    std::vector<std::string> tokens;\n\n    while (getline(ss, item, delim))\n        tokens.push_back(item);\n\n    return tokens;\n}\n\nint main() {\n    std::ifstream file("data.csv");\n    if (!file.is_open()) {\n        std::cerr << "Failed to open CSV file." << std::endl;\n        return 1;\n    }\n\n    std::string line;\n    std::vector<std::vector<std::string>> data;\n\n    // Read each line from the file\n    while (getline(file, line)) {\n        // Split the line into columns based on commas and push to vector of vectors\n        std::vector<std::string> row = split(line, ',');\n        data.push_back(row);\n    }\n    \n    file.close();\n\n    // Example: print the contents of the CSV\n    for (const auto &row : data) {\n        for (const auto &cell : row) {\n            std::cout << cell << " ";\n        }\n        std::cout << std::endl;\n    }\n\n    return 0;\n}