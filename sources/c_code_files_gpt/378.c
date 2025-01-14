#include <winsock2.h>
#include <iphlpapi.h>
#include <stdio.h>
#include <windows.h>

#pragma comment(lib, "ws2_32.lib")
#pragma comment(lib, "iphlpapi.lib")

int main() {
    HANDLE hAddrChange = NULL;
    OVERLAPPED overlapped = {0};
    DWORD dwRetVal;

    // Initialize the overlapped structure
    ZeroMemory(&overlapped, sizeof(overlapped));

    // Notify address change
    dwRetVal = NotifyAddrChange(&hAddrChange, &overlapped);
    if (dwRetVal == ERROR_IO_PENDING) {
        printf("Waiting for address change notification...\n");
        WaitForSingleObject(hAddrChange, INFINITE);
        printf("Network interface changed\n");
    } else {
        printf("NotifyAddrChange failed with error: %ld\n", dwRetVal);
    }

    // Clean up
    if (hAddrChange != NULL) {
        CloseHandle(hAddrChange);
    }

    return 0;
}