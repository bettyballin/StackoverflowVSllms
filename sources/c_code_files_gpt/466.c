#include <windows.h>
#include <wininet.h>
#include <stdio.h>

#define BUF_SIZE 4096

int main() {
    HINTERNET hSession = NULL, hConnect = NULL, hRequest = NULL;
    BOOL bRet;
    DWORD dwFlags = INTERNET_FLAG_SECURE;
    const char* szServer = "example.com";
    const char* szPath = "/path/to/resource";
    const char* szPostData = "param1=value1&param2=value2";
    DWORD dwPostDataLength = strlen(szPostData);
    char szBuffer[BUF_SIZE];
    DWORD dwBytesRead;

    // Initialize WinInet
    hSession = InternetOpen("WinInet Example", INTERNET_OPEN_TYPE_DIRECT, NULL, NULL, 0);
    if (!hSession) {
        printf("InternetOpen error: %lu\n", GetLastError());
        return 1;
    }

    // Open a connection to the server
    hConnect = InternetConnect(hSession, szServer, INTERNET_DEFAULT_HTTPS_PORT, NULL, NULL, INTERNET_SERVICE_HTTP, 0, 0);
    if (!hConnect) {
        printf("InternetConnect error: %lu\n", GetLastError());
        InternetCloseHandle(hSession);
        return 1;
    }

    // Open an HTTP request
    hRequest = HttpOpenRequest(hConnect, "POST", szPath, NULL, NULL, NULL, dwFlags, 0);
    if (!hRequest) {
        printf("HttpOpenRequest error: %lu\n", GetLastError());
        InternetCloseHandle(hConnect);
        InternetCloseHandle(hSession);
        return 1;
    }

    // Send the HTTP request with POST data
    bRet = HttpSendRequest(hRequest, "Content-Type: application/x-www-form-urlencoded", -1, (LPVOID)szPostData, dwPostDataLength);
    if (!bRet) {
        printf("HttpSendRequest error: %lu\n", GetLastError());
        InternetCloseHandle(hRequest);
        InternetCloseHandle(hConnect);
        InternetCloseHandle(hSession);
        return 1;
    }

    // Read the response
    do {
        bRet = InternetReadFile(hRequest, szBuffer, BUF_SIZE, &dwBytesRead);
        if (bRet && dwBytesRead > 0) {
            printf("%.*s", dwBytesRead, szBuffer);
        }
    } while (bRet && dwBytesRead > 0);

    if (!bRet) {
        printf("InternetReadFile error: %lu\n", GetLastError());
    }

    // Clean up
    InternetCloseHandle(hRequest);
    InternetCloseHandle(hConnect);
    InternetCloseHandle(hSession);

    return 0;
}