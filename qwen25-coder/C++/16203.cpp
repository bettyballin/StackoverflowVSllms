#include <iostream>\n#include <fstream>\n#include <string>\n#include <filesystem>\n#include <vector>\n\nusing namespace std;\nnamespace fs = std::filesystem;\n\nint countLOC(ifstream& inFile) {\n    int count = 0;\n    string line;\n    while (getline(inFile, line)) {\n        count++;\n    }\n    return count;\n}\n\nvoid listTextFilesInDirectory(const string& dirPath) {\n    if (!fs::exists(dirPath) || !fs::is_directory(dirPath)) {\n        cout << "\n**Invalid directory path**\n\n";\n        return;\n    }\n\n    int textFileCount = 0;\n    vector<string> textFiles;\n\n    for (const auto & entry : fs::directory_iterator(dirPath)) {\n        if (entry.is_regular_file() && entry.path().extension() == ".txt") {\n            textFiles.push_back(entry.path().filename().string());\n            textFileCount++;\n        }\n    }\n\n    cout << "Text files in the directory:\n";\n    for (const auto & file : textFiles) {\n        cout << "- " << file << "\n";\n    }\n    cout << "Total number of text files: " << textFileCount << "\n";\n}\n\nint main() {\n\n    ifstream inFile;\n    int result;\n    string input;\n\n    cout << "If the executable is not in the same directory as the file, then provide the full path.\n"\n            "Alternatively, to list all text files in a directory, specify the directory path.\n\n";\n\n    while (true) {\n        cout << "Enter the file or directory name:  ";\n        getline(cin, input);\n\n        // Check if it's a valid file\n        inFile.open(input.c_str(), ios::in);\n        if (inFile.is_open()) {\n            result = countLOC(inFile);\n            cout << "\nThere are " << result << " lines of code in \"" << input << "\"\n\n";\n            inFile.close();\n            break;\n        }\n        \n        // Check if it's a valid directory\n        else if (fs::exists(input) && fs::is_directory(input)) {\n            listTextFilesInDirectory(input);\n            break;\n        }\n\n        cout << "\n**File or directory failed to open/locate. Please try again**\n\n";\n    }\n\n    return 0;\n}