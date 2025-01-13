#include <iostream>\n#include <fstream>\n#include <unordered_map>\n#include <vector>\n#include <string>\n#include <sstream>\n#include <algorithm>\n\n// Define the structure for the inverted index\nusing InvertedIndex = std::unordered_map<std::string, std::vector<int>>;\n\n// Function to build the index\nvoid buildIndex(const std::string& logFile, InvertedIndex& index) {\n    std::ifstream file(logFile);\n    std::string line;\n    int lineNumber = 0;\n\n    while (std::getline(file, line)) {\n        std::istringstream iss(line);\n        std::string word;\n        while (iss >> word) {\n            std::transform(word.begin(), word.end(), word.begin(), ::tolower); // Convert to lowercase\n            index[word].push_back(lineNumber);\n        }\n        ++lineNumber;\n    }\n\n    file.close();\n}\n\n// Function to search the index\nstd::vector<int> searchIndex(const InvertedIndex& index, const std::string& query) {\n    std::string lowerQuery = query;\n    std::transform(lowerQuery.begin(), lowerQuery.end(), lowerQuery.begin(), ::tolower);\n\n    auto it = index.find(lowerQuery);\n    if (it != index.end()) {\n        return it->second;\n    } else {\n        return {};\n    }\n}\n\nint main() {\n    // Path to the log file\n    std::string logFile = "path/to/logfile.log";\n\n    // Create the inverted index\n    InvertedIndex index;\n    buildIndex(logFile, index);\n\n    // Example search query\n    std::string query = "search_term";\n    std::vector<int> results = searchIndex(index, query);\n\n    // Output the results\n    std::cout << "Search results for '" << query << "':" << std::endl;\n    for (int lineNum : results) {\n        std::cout << "Line " << lineNum << std::endl;\n    }\n\n    return 0;\n}