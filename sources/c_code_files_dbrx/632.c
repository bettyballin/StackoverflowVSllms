#include <windows.h>
#include <stdio.h>

int main() {
    const char* FilePath = "path/to/your/file"; // replace with the actual file path
    HANDLE hFile = CreateFileA(FilePath, GENERIC_WRITE, 0, NULL, OPEN_EXISTING, FILE_ATTRIBUTE_NORMAL, NULL);
    if (hFile == INVALID_HANDLE_VALUE) {
        DWORD lastErr = GetLastError();
        if (lastErr != ERROR_SHARING_VIOLATION && lastErr != ERROR_ACCESS_DENIED) {
            // Handle other errors as necessary...
            printf("CreateFile failed: %d\n", lastErr);
            return lastErr;
        } else { /* The file is in use or insufficient privileges, retry with MovefileEx */}
    }
    return 0;
}