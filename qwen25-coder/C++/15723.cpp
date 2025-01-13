#include <windows.h>\n#include <iostream>\n\nvoid printSystemMemory() {\n    MEMORYSTATUSEX status;\n    status.dwLength = sizeof(status);\n    GlobalMemoryStatusEx(&status);\n\n    std::cout << "Total Physical Memory: " << (status.ullTotalPhys / 1024 / 1024) << " MB" << std::endl;\n}\n\nint main() {\n    printSystemMemory();\n    return 0;\n}