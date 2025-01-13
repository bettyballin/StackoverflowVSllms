#include <fstream>\n\nint main() {\n    const char* filename = "yourfile.bin";\n    const size_t fileSize = 1024 * 1024 * 1024; // 1GB, adjust according to your file size\n\n    // Open the file in binary mode\n    std::ifstream file(filename, std::ios::binary | std::ios::ate);\n    if (!file.is_open()) {\n        // Handle file open error\n        return 1;\n    }\n\n    // Get the file size\n    size_t size = file.tellg();\n    file.seekg(0, std::ios::beg);\n\n    // Allocate memory for the file contents\n    char* buffer = new char[size];\n\n    // Read the file contents into RAM\n    file.read(buffer, size);\n\n    // Don't forget to free the memory when you're done\n    delete[] buffer;\n\n    return 0;\n}