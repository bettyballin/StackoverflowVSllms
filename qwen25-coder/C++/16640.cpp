#include <iostream>\n#include <fstream>\n#include <vector>\n#include <unistd.h>\n#include <sys/wait.h>\n\nvoid searchInChunk(const std::string& filename, long startOffset, long endOffset, const std::string& searchString) {\n    std::ifstream file(filename, std::ios::in);\n    if (!file.is_open()) {\n        std::cerr << "Child process could not open file." << std::endl;\n        return;\n    }\n    file.seekg(startOffset);\n    \n    char buffer[endOffset - startOffset + 1];\n    file.read(buffer, endOffset - startOffset);\n    std::string content(buffer, file.gcount());\n\n    if (content.find(searchString) != std::string::npos) {\n        std::cout << "Found \"" << searchString << "\" in child process with PID: " << getpid() << std::endl;\n    }\n\n    file.close();\n}\n\nint main(int argc, char* argv[]) {\n    if (argc < 4) {\n        std::cerr << "Usage: " << argv[0] << " [filename] [search_string] [max_processes]" << std::endl;\n        return 1;\n    }\n\n    const std::string filename = argv[1];\n    const std::string searchString = argv[2];\n    int maxProcesses = atoi(argv[3]);\n\n    std::ifstream file(filename, std::ios::in | std::ios::ate);\n    if (!file.is_open()) {\n        std::cerr << "Main process could not open file." << std::endl;\n        return 1;\n    }\n\n    long fileSize = static_cast<long>(file.tellg());\n    file.close();\n\n    int processesStarted = 0;\n\n    for (long startOffset = 0; startOffset < fileSize; startOffset += (fileSize / maxProcesses)) {\n        pid_t pid = fork();\n        if (pid == -1) {\n            std::cerr << "Fork failed!" << std::endl;\n            break;\n        }\n        if (pid == 0) { // Child process\n            long endOffset = startOffset + (fileSize / maxProcesses);\n            if (endOffset > fileSize) endOffset = fileSize;\n\n            searchInChunk(filename, startOffset, endOffset, searchString);\n\n            return 0; // Exit child process\n        }\n        processesStarted++;\n    }\n\n    for(int i = 0; i < processesStarted; i++) {\n        wait(NULL); // Wait for all children\n    }\n\n    return 0;\n}