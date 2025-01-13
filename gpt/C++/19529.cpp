#include <iostream>\n#include <fstream>\n#include <vector>\n#include <string>\n#include <algorithm>\n\n// Function to compare two lines based on the date (assuming the date is in the second column)\nbool compareLines(const std::string& line1, const std::string& line2) {\n    std::string date1 = line1.substr(line1.find(' ') + 1, 10);\n    std::string date2 = line2.substr(line2.find(' ') + 1, 10);\n    return date1 < date2;\n}\n\nint main() {\n    std::ifstream sourceFile("source.txt");\n    std::ofstream destFile("destination.txt", std::ios::app); // Use append mode to avoid overwriting\n\n    if (!sourceFile.is_open() || !destFile.is_open()) {\n        std::cerr << "Error opening files!" << std::endl;\n        return 1;\n    }\n\n    std::vector<std::string> lines;\n    std::string line;\n\n    // Read lines from the source file\n    while (std::getline(sourceFile, line)) {\n        lines.push_back(line);\n    }\n\n    // Sort the lines based on the custom comparator\n    std::sort(lines.begin(), lines.end(), compareLines);\n\n    // Write the sorted lines to the destination file\n    for (const auto& sortedLine : lines) {\n        destFile << sortedLine << std::endl;\n    }\n\n    sourceFile.close();\n    destFile.close();\n\n    return 0;\n}