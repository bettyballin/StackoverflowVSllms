#include <Windows.h>\n#include <iostream>\n\nvoid ReadFileWithoutLocking(const std::wstring& filePath) {\n    HANDLE hFile = CreateFile(filePath.c_str(), GENERIC_READ,\n                              FILE_SHARE_READ | FILE_SHARE_WRITE,  // Allow other processes to read and write.\n                              NULL, OPEN_EXISTING, FILE_ATTRIBUTE_NORMAL, NULL);\n    if (hFile == INVALID_HANDLE_VALUE) {\n        std::cerr << "Failed to open file: " << filePath;\n        return;\n    }\n\n    DWORD bytesRead;\n    char buffer[1024];\n    bool bSuccess = false;\n    while ((bSuccess = ReadFile(hFile, buffer, sizeof(buffer), &bytesRead, NULL)) && bytesRead > 0) {\n        std::cout.write(buffer, bytesRead);\n    }\n\n    if (!bSuccess && GetLastError() != ERROR_HANDLE_EOF) {\n        std::cerr << "Error reading file: ";\n    }\n\n    CloseHandle(hFile);\n}