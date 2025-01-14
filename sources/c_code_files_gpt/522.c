#include <Windows.h>

int main() {
    // Open a file
    HANDLE hFile = CreateFileA("example.txt", GENERIC_READ, 0, NULL, OPEN_ALWAYS, FILE_ATTRIBUTE_NORMAL, NULL);
    if (hFile == INVALID_HANDLE_VALUE) {
        // Handle the error
        return 1;
    }

    // Reopen the file
    HANDLE hReopenedFile = ReOpenFile(hFile, GENERIC_WRITE, 0, FILE_FLAG_OVERLAPPED);
    if (hReopenedFile == INVALID_HANDLE_VALUE) {
        // Handle the error
        CloseHandle(hFile);
        return 1;
    }

    // Use the reopened file handle
    // ...

    // Close the handles
    CloseHandle(hReopenedFile);
    CloseHandle(hFile);

    return 0;
}