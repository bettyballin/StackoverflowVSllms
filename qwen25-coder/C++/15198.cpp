#include <windows.h>\n#include <wininet.h>\n#include <tchar.h>\n\n#pragma comment(lib, "Wininet.lib")\n\nBOOL PerformHttpGETRequest(LPCTSTR pszUrl) {\n    HINTERNET hInternetOpen = InternetOpen(_T("MyAgent"), INTERNET_OPEN_TYPE_PROXY, _T("http://yourproxyserver:8080"), NULL, 0);\n    if (!hInternetOpen) return FALSE;\n\n    HINTERNET hHttpOpenRequest = HttpOpenRequest(hInternetOpen, _T("GET"), pszUrl, NULL, NULL, NULL, INTERNET_FLAG_RELOAD, NULL);\n    if (!hHttpOpenRequest) {\n        InternetCloseHandle(hInternetOpen);\n        return FALSE;\n    }\n\n    BOOL bResults = HttpSendRequest(hHttpOpenRequest, NULL, 0, NULL, 0);\n    if (bResults) {\n        TCHAR szOutBuffer[4096];\n        DWORD dwBytesRead;\n        while (InternetReadFile(hHttpOpenRequest, (LPVOID)szOutBuffer, sizeof(szOutBuffer), &dwBytesRead)) {\n            if (!dwBytesRead) break;\n\n            _tprintf(szOutBuffer);\n        }\n    }\n\n    InternetCloseHandle(hHttpOpenRequest);\n    InternetCloseHandle(hInternetOpen);\n\n    return bResults;\n}\n\nint main() {\n    LPCTSTR url = _T("http://example.com");\n    if (PerformHttpGETRequest(url)) {\n        _tprintf(_T("Request succeeded.\n"));\n    } else {\n        _tprintf(_T("Request failed with error %lu.\n"), GetLastError());\n    }\n    return 0;\n}