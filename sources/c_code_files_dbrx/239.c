#include <windows.h>

int main() {
    HANDLE handle;
    HANDLE writeHandle;

    // Initialize handles here...
    // For example:
    handle = CreateFile("example.txt", GENERIC_READ, 0, NULL, OPEN_EXISTING, 0, NULL);
    writeHandle = CreateFile("example.txt", GENERIC_WRITE, 0, NULL, OPEN_EXISTING, 0, NULL);

    // Your original code
    CloseHandle(handle);
    CloseHandle(writeHandle);

    return 0;
}