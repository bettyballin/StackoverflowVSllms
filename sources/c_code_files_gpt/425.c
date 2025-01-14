#include <windows.h>

void deleteFileOnClose(const char *filePath) {
    HANDLE hFile = CreateFile(filePath, DELETE, 0, NULL, OPEN_EXISTING, FILE_FLAG_DELETE_ON_CLOSE, NULL);
    if (hFile != INVALID_HANDLE_VALUE) {
        // File will be deleted when the handle is closed
        CloseHandle(hFile);
    } else {
        // Handle error
        printf("Error deleting file: %d\n", GetLastError());
    }
}

int main() {
    deleteFileOnClose("path_to_your_file.txt");
    return 0;
}