#include <windows.h>\n#include <iostream>\n\nint main() {\n    // Create or open a named mutex\n    HANDLE hMutex = CreateMutex(NULL, FALSE, L"Global\\RegistryMutex");\n    if (hMutex == NULL) {\n        std::cerr << "CreateMutex failed: " << GetLastError() << std::endl;\n        return 1;\n    }\n\n    // Wait for ownership of the mutex\n    DWORD dwWaitResult = WaitForSingleObject(hMutex, INFINITE);\n    if (dwWaitResult == WAIT_OBJECT_0) {\n        // Successfully obtained the mutex, safe to access the registry\n        HKEY hKey;\n        LONG lResult = RegOpenKeyEx(HKEY_LOCAL_MACHINE, L"SOFTWARE\\MyKey", 0, KEY_READ, &hKey);\n        if (lResult == ERROR_SUCCESS) {\n            // Perform registry operations here\n            RegCloseKey(hKey);\n        } else {\n            std::cerr << "RegOpenKeyEx failed: " << lResult << std::endl;\n        }\n\n        // Release ownership of the mutex\n        if (!ReleaseMutex(hMutex)) {\n            std::cerr << "ReleaseMutex failed: " << GetLastError() << std::endl;\n        }\n    } else {\n        std::cerr << "WaitForSingleObject failed: " << GetLastError() << std::endl;\n    }\n\n    // Close the mutex handle\n    CloseHandle(hMutex);\n    return 0;\n}