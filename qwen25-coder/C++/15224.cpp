#include <windows.h>\n#include <iostream>\n#include <tchar.h>\n\nvoid GetFileSizeAndDate(const TCHAR* filePath) {\n    WIN32_FILE_ATTRIBUTE_DATA fileInfo;\n    \n    if (GetFileAttributesEx(filePath, GetFileExInfoStandard, &fileInfo)) {\n        ULARGE_INTEGER fileSize;\n        SYSTEMTIME lastWriteTime;\n\n        // Calculate file size\n        fileSize.LowPart = fileInfo.nFileSizeLow;\n        fileSize.HighPart = fileInfo.nFileSizeHigh;\n        \n        // Convert the last write time to local time\n        FileTimeToLocalFileTime(&fileInfo.ftLastWriteTime, &fileInfo.ftLastWriteTime);\n        FileTimeToSystemTime(&fileInfo.ftLastWriteTime, &lastWriteTime);\n\n        std::wcout << _T("File path: ") << filePath << std::endl;\n        std::wcout << _T("Size: ") << fileSize.QuadPart << _T(" bytes") << std::endl;\n        std::wcout << _T("Last modified: ")\n                   << lastWriteTime.wYear << _T("-")\n                   << lastWriteTime.wMonth << _T("-")\n                   << lastWriteTime.wDay << _T(" ")\n                   << lastWriteTime.wHour << _T(":")\n                   << lastWriteTime.wMinute << _T(":")\n                   << lastWriteTime.wSecond << std::endl;\n    } else {\n        std::wcerr << _T("GetFileAttributesEx failed! Error: ") << GetLastError() << std::endl;\n    }\n}\n\nint main() {\n    const TCHAR* filePath = _T("C:\\path\\to\\your\\file.txt");\n    GetFileSizeAndDate(filePath);\n    return 0;\n}