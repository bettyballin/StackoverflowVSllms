#include <Windows.h>\n\nint main() {\n    const char* filePath = "path/to/your/file.exe";\n    DWORD attributes = GetFileAttributes(filePath);\n    if (attributes != INVALID_FILE_ATTRIBUTES) {\n        if (attributes & 0x800) {\n            // File is blocked\n        } else {\n            // File is not blocked\n        }\n    }\n    return 0;\n}