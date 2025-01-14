#include <windows.h>
#include <stdio.h>

int main() {
    BY_HANDLE_FILE_INFORMATION finfo;
    SYSTEMTIME systime;
    HANDLE file;

    // Create a file handle for reading
    file = CreateFile("test.txt", GENERIC_READ, FILE_SHARE_READ, NULL, OPEN_EXISTING, FILE_ATTRIBUTE_NORMAL, NULL);
    if (file == INVALID_HANDLE_VALUE) {
        printf("Failed to open file.\n");
        return 1;
    }

    // Get file information
    if (!GetFileInformationByHandle(file, &finfo)) {
        printf("Failed to get file information.\n");
        CloseHandle(file);
        return 1;
    }

    // Convert last write time to system time
    if (!FileTimeToSystemTime(&finfo.ftLastWriteTime, &systime)) {
        printf("Failed to convert file time to system time.\n");
        CloseHandle(file);
        return 1;
    }

    // Print system time
    printf("Last write time: %04d-%02d-%02d %02d:%02d:%02d\n",
           systime.wYear, systime.wMonth, systime.wDay,
           systime.wHour, systime.wMinute, systime.wSecond);

    CloseHandle(file);
    return 0;
}