#include <Windows.h>\n#include <iostream>\n#include <vector>\n\nstd::vector<std::string> GetDllDependencies(const char* executablePath) {\n    std::vector<std::string> dlls;\n    BYTE* data = nullptr;\n    HANDLE hFile = INVALID_HANDLE_VALUE;\n    HANDLE hMapping = nullptr;\n    __try {\n        hFile = CreateFileA(executablePath, GENERIC_READ, FILE_SHARE_READ, nullptr, OPEN_EXISTING, FILE_ATTRIBUTE_NORMAL, nullptr);\n        if (hFile == INVALID_HANDLE_VALUE) __leave;\n\n        hMapping = CreateFileMappingA(hFile, nullptr, PAGE_READONLY, 0, 0, nullptr);\n        if (hMapping == nullptr) __leave;\n\n        data = (BYTE*)MapViewOfFile(hMapping, FILE_MAP_READ, 0, 0, 0);\n        if (data == nullptr) __leave;\n\n        PIMAGE_DOS_HEADER dosHeader = (PIMAGE_DOS_HEADER)data;\n        PIMAGE_NT_HEADERS ntHeaders = (PIMAGE_NT_HEADERS)(data + dosHeader->e_lfanew);\n        PIMAGE_IMPORT_DESCRIPTOR importDesc = (PIMAGE_IMPORT_DESCRIPTOR)(data + ntHeaders->OptionalHeader.DataDirectory[IMAGE_DIRECTORY_ENTRY_IMPORT].VirtualAddress);\n\n        while (importDesc->Name) {\n            const char* dllName = (const char*)(data + importDesc->Name);\n            dlls.push_back(dllName);\n            importDesc++;\n        }\n    }\n    __finally {\n        if (data) UnmapViewOfFile(data);\n        if (hMapping != nullptr) CloseHandle(hMapping);\n        if (hFile != INVALID_HANDLE_VALUE) CloseHandle(hFile);\n    }\n    return dlls;\n}\n\nint main() {\n    const char* exePath = "path_to_your_executable.exe";\n    std::vector<std::string> dependencies = GetDllDependencies(exePath);\n\n    std::cout << "DLL Dependencies: " << std::endl;\n    for (const auto& dll : dependencies) {\n        std::cout << dll << std::endl;\n    }\n\n    return 0;\n}