#include <windows.h>

int main() {
    HANDLE hFile = CreateFile(TEXT("example.txt"), GENERIC_READ, 0, NULL, OPEN_EXISTING, FILE_ATTRIBUTE_NORMAL, NULL);
    if (hFile == INVALID_HANDLE_VALUE) {
        // Handle error
        return 1;
    }
    // Use the file handle...
    CloseHandle(hFile);
    return 0;
}