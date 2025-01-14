#include <windows.h>

int main() {
    HANDLE hFile = CreateFile("example.txt", GENERIC_WRITE, 0, NULL, CREATE_ALWAYS, FILE_ATTRIBUTE_NORMAL, NULL);
    if (hFile != INVALID_HANDLE_VALUE) {
        DWORD bytesWritten;
        const char *data = "Hello, World!\n";
        WriteFile(hFile, data, strlen(data), &bytesWritten, NULL);
        CloseHandle(hFile);
    } else {
        DWORD error = GetLastError();
        // Handle error
    }
    return 0;
}