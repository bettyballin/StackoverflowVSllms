#include <Windows.h>\n\nbool isFileWritable(const char* filename) {\n    DWORD attributes = GetFileAttributes(filename);\n    return !(attributes & FILE_ATTRIBUTE_READONLY);\n}\n\nbool isFileInUse(const char* filename) {\n    HANDLE hFile = CreateFile(filename, GENERIC_WRITE, FILE_SHARE_NONE, NULL, OPEN_EXISTING, 0, NULL);\n    if (hFile != INVALID_HANDLE_VALUE) {\n        CloseHandle(hFile);\n        return false;\n    }\n    return true;\n}\n\nint main() {\n    const char* filename = "path/to/file.txt";\n    while (true) {\n        if (isFileWritable(filename) && !isFileInUse(filename)) {\n            // file is writable and not in use, do something\n            break;\n        }\n        Sleep(1000); // wait 1 second and try again\n    }\n    return 0;\n}