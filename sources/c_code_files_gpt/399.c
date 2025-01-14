#include <windows.h>
#include <stdio.h>

int main(int argc, char *argv[]) {
    HANDLE file;
    BY_HANDLE_FILE_INFORMATION finfo;
    SYSTEMTIME systime, localTime;
    FILETIME localFileTime;

    file = CreateFile("test.txt", GENERIC_READ, FILE_SHARE_READ, NULL, OPEN_EXISTING, FILE_ATTRIBUTE_NORMAL, NULL);
    if (file == INVALID_HANDLE_VALUE) {
        printf("Could not open file (error %d)\n", GetLastError());
        return 1;
    }

    if (!GetFileInformationByHandle(file, &finfo)) {
        printf("Could not get file information (error %d)\n", GetLastError());
        CloseHandle(file);
        return 1;
    }

    // Convert the last write time to local file time
    if (!FileTimeToLocalFileTime(&finfo.ftLastWriteTime, &localFileTime)) {
        printf("Could not convert file time to local file time (error %d)\n", GetLastError());
        CloseHandle(file);
        return 1;
    }

    // Convert the local file time to system time
    if (!FileTimeToSystemTime(&localFileTime, &systime)) {
        printf("Could not convert file time to system time (error %d)\n", GetLastError());
        CloseHandle(file);
        return 1;
    }

    printf("  %s   %02d:%02d:%02d %d/%d/%d\n", "test.txt", systime.wHour, systime.wMinute, systime.wSecond, systime.wDay, systime.wMonth, systime.wYear);

    CloseHandle(file);
    return 0;
}