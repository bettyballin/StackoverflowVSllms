#include <windows.h>

int main() {
    LPVOID pBuf;
    HANDLE hMapFile;
    const DWORD BUF_SIZE = 1024; // replace with your buffer size

    // assuming you have initialized pBuf and hMapFile elsewhere
    // Zero out the memory
    SecureZeroMemory((PVOID)pBuf, BUF_SIZE);

    // Unmap and close the handle
    UnmapViewOfFile(pBuf);
    CloseHandle(hMapFile);

    return 0;
}