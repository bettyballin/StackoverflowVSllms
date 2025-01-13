class FileHandler : public IFileHandler {\npublic:\n    bool open(const std::string& filename) override {\n        file.open(filename, std::ios::in | std::ios::binary);\n        return file.is_open();\n    }\n\n    size_t getFileSize() override {\n        if (file.is_open()) {\n           (file.seekg(0, std::ios::end));\n            auto size = file.tellg();\n            (file.seekg(0, std::ios::beg));\n            return static_cast<size_t>(size);\n        }\n        return 0;\n    }\n\n    bool readFileToBuffer(void* buffer, size_t bufferSize) override {\n        if (file.is_open() && getFileSize() == bufferSize) {\n            file.read(reinterpret_cast<char*>(buffer), bufferSize);\n            return true;\n        }\n        return false;\n    }\n\nprivate:\n    std::ifstream file;\n};