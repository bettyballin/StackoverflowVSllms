#include <Windows.h>\n#include <WinInet.h>\n\nint main() {\n    HINTERNET hInternet, hConnect, hRequest;\n    char* postData = "key=value&foo=bar"; // Your POST data here\n    char szUrl[] = "https://example.com"; // Your URL here\n    char szUserAgent[] = "Mozilla/4.0 (compatible; MSIE 5.22)";\n    DWORD dwFlags;\n\n    hInternet = InternetOpenA(szUserAgent, INTERNET_OPEN_TYPE_PRECONFIG, NULL, NULL, 0);\n    if (hInternet == NULL) {\n        printf("InternetOpen failed: %d\n", GetLastError());\n        return 1;\n    }\n\n    hConnect = InternetConnectA(hInternet, szUrl, INTERNET_DEFAULT_HTTPS_PORT, NULL, NULL, INTERNET_SERVICE_HTTP, 0, 1);\n    if (hConnect == NULL) {\n        printf("InternetConnect failed: %d\n", GetLastError());\n        InternetCloseHandle(hInternet);\n        return 1;\n    }\n\n    hRequest = HttpOpenRequestA(hConnect, "POST", "/", NULL, NULL, NULL, INTERNET_FLAG_SECURE, 1);\n    if (hRequest == NULL) {\n        printf("HttpOpenRequest failed: %d\n", GetLastError());\n        InternetCloseHandle(hConnect);\n        InternetCloseHandle(hInternet);\n        return 1;\n    }\n\n    dwFlags = SECURITY_FLAG_IGNORE_CERT_CN_INVALID | SECURITY_FLAG_IGNORE_CERT_DATE_INVALID | SECURITY_FLAG_IGNORE_UNKNOWN_CA;\n    if (!InternetSetOption(hRequest, INTERNET_OPTION_SECURITY_FLAGS, &dwFlags, sizeof(dwFlags))) {\n        printf("InternetSetOption failed: %d\n", GetLastError());\n    }\n\n    if (!HttpSendRequestA(hRequest, "Content-Type: application/x-www-form-urlencoded", -1, postData, strlen(postData))) {\n        printf("HttpSendRequest failed: %d\n", GetLastError());\n        InternetCloseHandle(hRequest);\n        InternetCloseHandle(hConnect);\n        InternetCloseHandle(hInternet);\n        return 1;\n    }\n\n    // You can call InternetReadFile to read the response here.\n\n    InternetCloseHandle(hRequest);\n    InternetCloseHandle(hConnect);\n    InternetCloseHandle(hInternet);\n\n    return 0;\n}