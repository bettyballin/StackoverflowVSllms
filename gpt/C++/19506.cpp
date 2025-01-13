#include <windows.h>\n#include <iostream>\n\nvoid MoveFileOnReboot(const std::wstring &src, const std::wstring &dest) {\n    if(MoveFileEx(src.c_str(), dest.c_str(), MOVEFILE_DELAY_UNTIL_REBOOT)) {\n        std::wcout << L"File will be moved on reboot.\n";\n    } else {\n        DWORD error = GetLastError();\n        if (error == ERROR_SHARING_VIOLATION) {\n            std::wcerr << L"Error: File is in use.\n";\n        } else if (error == ERROR_ACCESS_DENIED) {\n            std::wcerr << L"Error: Access denied.\n";\n        } else if (error == ERROR_WRITE_PROTECT) {\n            std::wcerr << L"Error: Write protect.\n";\n        } else if (error == ERROR_INVALID_DRIVE) {\n            std::wcerr << L"Error: Invalid drive.\n";\n        } else {\n            std::wcerr << L"Error: " << error << L"\n";\n        }\n    }\n}\n\nint main() {\n    std::wstring src = L"C:\\path\\to\\source\\file.txt";\n    std::wstring dest = L"C:\\path\\to\\destination\\file.txt";\n    MoveFileOnReboot(src, dest);\n    return 0;\n}