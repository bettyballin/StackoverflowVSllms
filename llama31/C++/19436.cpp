#include <Windows.h>\n#include <psapi.h>\n\nint main() {\n    HANDLE hFile = CreateFileA("your_file.txt", GENERIC_READ, FILE_SHARE_READ, NULL, OPEN_EXISTING, FILE_ATTRIBUTE_NORMAL, NULL);\n    if (hFile == INVALID_HANDLE_VALUE) {\n        return 1;\n    }\n\n    HANDLE hMap = CreateFileMappingA(hFile, NULL, PAGE_READONLY, 0, 0, NULL);\n    if (hMap == NULL) {\n        CloseHandle(hFile);\n        return 1;\n    }\n\n    LPVOID pMap = MapViewOfFile(hMap, FILE_MAP_READ, 0, 0, 0);\n    if (pMap == NULL) {\n        CloseHandle(hMap);\n        CloseHandle(hFile);\n        return 1;\n    }\n\n    MEMORY_BASIC_INFORMATION mbi;\n    VirtualQueryEx(GetCurrentProcess(), pMap, &mbi, sizeof(mbi));\n\n    // Check if the memory region is still valid\n    if (mbi.State == MEM_COMMIT && mbi.Protect == PAGE_READONLY) {\n        // The memory region is still valid, but it's not guaranteed to be in physical RAM\n    }\n\n    UnmapViewOfFile(pMap);\n    CloseHandle(hMap);\n    CloseHandle(hFile);\n    return 0;\n}