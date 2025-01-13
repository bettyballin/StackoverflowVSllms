class FileReaderStatic {\npublic:\n    static bool initialize(const std::string& filename) {\n        try {\n            FileReader::instance.readFile(filename);\n            return true;\n        } catch (const std::exception& e) {\n            // Handle exception\n            std::cerr << "Error: " << e.what() << std::endl;\n            return false;\n        }\n    }\n\nprivate:\n    struct FileReaderImpl : public FileReader {};\n    static inline FileReaderImpl instance;  // Static instance\n};\n\n// In global scope or main, perform initialization\nbool fileReaderInitialized = FileReaderStatic::initialize("input.txt");\n\nint main() {\n    if (!fileReaderInitialized) {\n        // Handle error\n        return -1;\n    }\n    // Continue with normal execution\n}