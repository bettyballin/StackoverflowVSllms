#include <windows.h>\n#include <tchar.h>\n\nbool setRegistryValue(bool enabled) {\n    DWORD dwData = enabled ? 120 : 0; // Assuming you want to set it to 0 or 120 based on 'enabled'\n    LONG result = RegSetValueEx(HKEY_LOCAL_MACHINE, _T("System\\CurrentControlSet\\Control\\Power\\Timeouts\\BattSuspendTimeout"), 0, REG_DWORD, (LPBYTE)&dwData, sizeof(DWORD));\n    \n    if (result != ERROR_SUCCESS) {\n        // Handle the error here, print it or log it\n        TCHAR errorMessage[256];\n        FormatMessage(FORMAT_MESSAGE_FROM_SYSTEM | FORMAT_MESSAGE_IGNORE_INSERTS,\n                      NULL, result, MAKELANGID(LANG_NEUTRAL, SUBLANG_DEFAULT),\n                      errorMessage, (sizeof(errorMessage) / sizeof(TCHAR)), NULL);\n        \n        _tprintf(_T("Failed to set registry value: %s\n"), errorMessage);\n        return false;\n    }\n    \n    return true;\n}