#include <windows.h>\n#include <iostream>\n\nBOOL DelayMoveFile(const std::wstring& src, const std::wstring& dst) {\n    BOOL success = MoveFileEx(src.c_str(), dst.c_str(),\n                              MOVEFILE_DELAY_UNTIL_REBOOT | MOVEFILE_REPLACE_EXISTING);\n    if (!success) {\n        DWORD error = GetLastError();\n        switch (error) {\n            case ERROR_ACCESS_DENIED:\n                std::cerr << "Access Denied: You don't have permission to move this file." << std::endl;\n                break;\n            case ERROR_SHARING_VIOLATION:\n                std::cerr << "File in Use: The file is currently being used by another process and will be moved at reboot." << std::endl;\n                return TRUE; // Indicate that the error was handled\n            case ERROR_FILE_BUSY:\n                std::cerr << "File Busy: The file is busy and will be moved at reboot." << std::endl;\n                return TRUE; // Indicate that the error was handled\n            default:\n                std::cerr << "Error moving file: " << error << std::endl;\n                break;\n        }\n    }\n    return success;\n}