#include <windows.h>\n#include <tlhelp32.h>\n#include <string>\n#include <iostream>\n\nHANDLE GetProcessHandleByName(const std::wstring& processName) {\n    HANDLE hSnapshot = CreateToolhelp32Snapshot(TH32CS_SNAPPROCESS, 0);\n    if (hSnapshot == INVALID_HANDLE_VALUE) {\n        return NULL;\n    }\n\n    PROCESSENTRY32 pe;\n    pe.dwSize = sizeof(PROCESSENTRY32);\n\n    if (!Process32First(hSnapshot, &pe)) {\n        CloseHandle(hSnapshot);\n        return NULL;\n    }\n\n    do {\n        if (std::wstring(pe.szExeFile) == processName) {\n            HANDLE hProcess = OpenProcess(PROCESS_TERMINATE, FALSE, pe.th32ProcessID);\n            CloseHandle(hSnapshot);\n            return hProcess;\n        }\n    } while (Process32Next(hSnapshot, &pe));\n\n    CloseHandle(hSnapshot);\n    return NULL;\n}\n\nint main() {\n    std::wstring processName = L"example.exe";\n    HANDLE hProcess = GetProcessHandleByName(processName);\n\n    if (hProcess != NULL) {\n        std::wcout << L"Found process: " << processName << std::endl;\n        // TerminateProcess(hProcess, 0); // Uncomment to terminate the process\n        CloseHandle(hProcess);\n    } else {\n        std::wcout << L"Process not found: " << processName << std::endl;\n    }\n\n    return 0;\n}