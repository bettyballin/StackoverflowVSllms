#include <windows.h>

#define BUF_SIZE 1024
char sensitiveData[BUF_SIZE];

int main() {
    SECURITY_ATTRIBUTES sa;
    sa.nLength = sizeof(sa);
    sa.lpSecurityDescriptor = NULL; // Set a proper security descriptor here
    sa.bInheritHandle = TRUE;

    HANDLE hMapFile = CreateFileMapping(
        INVALID_HANDLE_VALUE,
        &sa,
        PAGE_READWRITE,
        0,
        BUF_SIZE,
        "Local\\MySharedMemory");

    if (hMapFile == NULL) {
        // Handle error
        return 1;
    }

    LPVOID pBuf = MapViewOfFile(
        hMapFile,
        FILE_MAP_ALL_ACCESS,
        0,
        0,
        BUF_SIZE);

    if (pBuf == NULL) {
        // Handle error
        CloseHandle(hMapFile);
        return 1;
    }

    // Copy sensitive data to the shared memory
    CopyMemory(pBuf, sensitiveData, sizeof(sensitiveData));

    // Don't forget to unmap the view and close the handle when you're done
    UnmapViewOfFile(pBuf);
    CloseHandle(hMapFile);

    return 0;
}