#include <windows.h>

int main() {
    const int BufferSize = 1024 * 32; // buffer size for changes
    DWORD dwBufLength = BufferSize;
    char lpBuffer[BufferSize];           // this could hold the list of updates

    HANDLE dirHandle = CreateFile(
        L"C:\\YourDirectory", GENERIC_READ, FILE_SHARE_WRITE | FILE_SHARE_DELETE, NULL, OPEN_EXISTING,
        FILE_FLAG_BACKUP_SEMANTICS | FILE_FLAG_OVERLAPPED, NULL); // open the directory

    if (dirHandle == INVALID_HANDLE_VALUE) {
        // handle error
        return 1;
    }

    ReadDirectoryChangesW(dirHandle,(LPVOID)lpBuffer,&dwBufLength,\
        FILE_NOTIFY_CHANGE_LAST_WRITE|FILE_NOTIFY_CHANGE_CREATION|\
        FILE_NOTIFY_CHANGE_DIR_NAME ,FALSE,NULL, NULL); // Watch for these changes

    CloseHandle(dirHandle);
    return 0;
}