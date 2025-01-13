#include <Windows.h>\n#include <iostream>\n\nint main() {\n    WIN32_FIND_DATA findData;\n    HANDLE hFind;\n\n    hFind = FindFirstFile("C:\\path\\to\\directory\\*.*", &findData);\n\n    if (hFind != INVALID_HANDLE_VALUE) {\n        do {\n            std::cout << findData.cFileName << std::endl;\n        } while (FindNextFile(hFind, &findData));\n        FindClose(hFind);\n    } else {\n        // Handle error\n    }\n\n    return 0;\n}