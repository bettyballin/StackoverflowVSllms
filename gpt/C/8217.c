#include <windows.h>\n#include <stdio.h>\n#include <tchar.h>\n\nint main() {\n    HKEY hKey;\n    LPCTSTR sk = TEXT("SOFTWARE\\TestSoftware");\n\n    // Open the key\n    LONG openRes = RegOpenKeyEx(HKEY_LOCAL_MACHINE, sk, 0, KEY_ALL_ACCESS, &hKey);\n\n    if (openRes == ERROR_SUCCESS) {\n        _tprintf(TEXT("Success opening key.\n"));\n    } else {\n        _tprintf(TEXT("Error opening key: %ld\n"), openRes);\n        return 1;  // Exit if the key couldn't be opened\n    }\n\n    // Define the value name and data\n    LPCTSTR value = TEXT("TestSoftwareKey");\n    LPCTSTR data = TEXT("TestData");\n\n    // Set the value in the registry\n    LONG setRes = RegSetValueEx(hKey, value, 0, REG_SZ, (const BYTE*)data, (_tcslen(data) + 1) * sizeof(TCHAR));\n\n    if (setRes == ERROR_SUCCESS) {\n        _tprintf(TEXT("Success writing to Registry.\n"));\n    } else {\n        _tprintf(TEXT("Error writing to Registry: %ld\n"), setRes);\n    }\n\n    // Close the key\n    LONG closeOut = RegCloseKey(hKey);\n\n    if (closeOut == ERROR_SUCCESS) {\n        _tprintf(TEXT("Success closing key.\n"));\n    } else {\n        _tprintf(TEXT("Error closing key: %ld\n"), closeOut);\n    }\n\n    return 0;\n}