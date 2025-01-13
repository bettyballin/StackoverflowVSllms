#include <Windows.h>\n#include <stdio.h>\n\nint main() {\n    HANDLE hFile;\n    hFile = CreateFile("example.txt",               // file name\n                       GENERIC_READ,                // desired access\n                       0,                           // share mode\n                       NULL,                        // security attributes\n                       OPEN_EXISTING,               // creation disposition\n                       FILE_ATTRIBUTE_NORMAL,       // flags and attributes\n                       NULL);                       // template file handle\n\n    if (hFile == INVALID_HANDLE_VALUE) {\n        printf("Could not open file (error %d)\n", GetLastError());\n        return 1;\n    }\n\n    // Use hFile with other API functions, e.g., GetFileTime, ReadFile, etc.\n\n    CloseHandle(hFile);\n    return 0;\n}