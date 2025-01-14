#include <windows.h>

int truncate_file(const char* filename) {
    HANDLE filehandle = CreateFileA(filename, GENERIC_WRITE, FILE_SHARE_READ | FILE_SHARE_WRITE, NULL, OPEN_EXISTING, 0, NULL);
    if (filehandle != INVALID_HANDLE_VALUE) {
        BOOL truncate_result = SetEndOfFile(filehandle);
        CloseHandle(filehandle);
        if (!truncate_result) {
            DWORD lastError = GetLastError();
            // Handle the error or return an appropriate exit code.
            return 1; // Return a non-zero value to indicate error
        } else {
            // File truncation was successful.
            return 0; // Return zero to indicate success
        }
    } else {
       // Error handling: CreateFileA has failed to open file.
       return 1; // Return a non-zero value to indicate error
    }
}

int main() {
    // Call the truncate_file function
    truncate_file("example.txt");
    return 0;
}