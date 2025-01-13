#include <iostream>\n#include <fstream>\n#include <thread>\n#include <chrono>\n\nbool isFileWritable(const std::string& filename) {\n    std::ofstream testFileStream(filename, std::ios::out | std::ios::app);\n    if (testFileStream.is_open()) {\n        testFileStream.close(); // Close file immediately after opening\n        return true;\n    }\n    return false;\n}\n\nvoid waitForFileUnlock(const std::string& filename) {\n    while (!isFileWritable(filename)) {\n        // Sleep for a short duration before retrying\n        std::this_thread::sleep_for(std::chrono::seconds(1));\n    }\n    std::cout << "File is now writable." << std::endl;\n    // You can perform your operations here once the file is accessible\n}\n\nint main() {\n    std::string filename = "example.txt"; // Replace with your target file name\n    waitForFileUnlock(filename);\n    return 0;\n}