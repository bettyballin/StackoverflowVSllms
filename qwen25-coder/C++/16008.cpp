#include <windows.h>\n#include <winhttp.h>\n\n#pragma comment(lib, "winhttp.lib")\n\nint main() {\n    WINHTTP_CURRENT_USER_IE_PROXY_CONFIG ieProxyConfig;\n    \n    if (WinHttpGetIEProxyConfigForCurrentUser(&ieProxyConfig)) {\n        // Use the proxy config information as needed\n        printf("Access type: %lu\n", ieProxyConfig.dwAccessType);\n        \n        // Free allocated memory when done\n        GlobalFree(ieProxyConfig.lpszAutoConfigUrl);\n        GlobalFree(ieProxyConfig.lpszProxy);\n        GlobalFree(ieProxyConfig.lpszProxyBypass);\n    } else {\n        printf("Failed to get IE proxy config. Error: %lu\n", GetLastError());\n    }\n    \n    return 0;\n}