#include <windows.h>\n#include <winhttp.h>\n#include <stdio.h>\n\nvoid GetProxySettings() {\n    WINHTTP_CURRENT_USER_IE_PROXY_CONFIG proxyConfig;\n\n    if (WinHttpGetIEProxyConfigForCurrentUser(&proxyConfig)) {\n        if (proxyConfig.lpszProxy != NULL) {\n            wprintf(L"Proxy: %s\n", proxyConfig.lpszProxy);\n            GlobalFree(proxyConfig.lpszProxy);\n        } else {\n            wprintf(L"No manual proxy configured.\n");\n        }\n\n        if (proxyConfig.lpszProxyBypass != NULL) {\n            wprintf(L"Proxy Bypass: %s\n", proxyConfig.lpszProxyBypass);\n            GlobalFree(proxyConfig.lpszProxyBypass);\n        }\n\n        if (proxyConfig.lpszAutoConfigUrl != NULL) {\n            wprintf(L"Auto Config URL: %s\n", proxyConfig.lpszAutoConfigUrl);\n            GlobalFree(proxyConfig.lpszAutoConfigUrl);\n        }\n\n        if (proxyConfig.fAutoDetect) {\n            wprintf(L"Auto Detect: Enabled\n");\n        } else {\n            wprintf(L"Auto Detect: Disabled\n");\n        }\n    } else {\n        wprintf(L"Failed to get proxy configuration. Error: %d\n", GetLastError());\n    }\n}\n\nint main() {\n    GetProxySettings();\n    return 0;\n}