#include <windows.h>\n#include <winnetwk.h>\n#include <tchar.h>\n\nvoid ConvertUncToMappedDrive(TCHAR* szPath) {\n    TCHAR szBuffer[MAX_PATH];\n    TCHAR szNetworkName[MAX_PATH];\n\n    // Extract the drive letter and convert UNC path to mapped drive\n    if (szPath[1] == TEXT(':')) {\n        szBuffer[0] = szPath[0];  // Copy the drive letter to buffer\n        szBuffer[1] = szPath[1];\n        szBuffer[2] = TEXT('\0');\n\n        DWORD dwSize = MAX_PATH;\n        if (WNetGetConnection(szBuffer, szNetworkName, &dwSize) == NO_ERROR) {\n            // Replace UNC path prefix with drive letter\n            TCHAR* pStartOfFileName = _tcschr(szPath + 3, TEXT('\\'));\n            if (pStartOfFileName != NULL) {\n                _tcscpy_s(pStartOfFileName - 2, MAX_PATH, szBuffer);\n            }\n        }\n    }\n}\n\nint main() {\n    TCHAR buf[MAX_PATH];\n    GetModuleFileName(NULL, buf, sizeof(buf));\n\n    // Convert the UNC path to a mapped drive letter if applicable\n    ConvertUncToMappedDrive(buf);\n\n    _tprintf(_T("Path: %s\n"), buf);\n    return 0;\n}