#include <windows.h>
#include <stdio.h>

int main() {
    char path[100];
    HANDLE hDir;

    // Specify the directory path you want to monitor
    // For example, monitoring the root of drive C
    strcpy(path, "C:\\");
    
    // Find the first change notification. Watch for file names changes.
    hDir = FindFirstChangeNotification(
        path,                         // directory to watch 
        FALSE,                        // do not watch subtree 
        FILE_NOTIFY_CHANGE_FILE_NAME, // watch file name changes
        NULL,                         // no buffer 
        NULL                          // no async context 
    );

    if (hDir == INVALID_HANDLE_VALUE) {
        printf("FindFirstChangeNotification failed (%d)\n", GetLastError());
        return 1;
    }

    printf("Waiting for changes in %s...\n", path);

    // Infinite loop to continuously monitor for changes
    for (;;) {
        DWORD dwWaitStatus;
        dwWaitStatus = WaitForSingleObject(hDir, INFINITE);

        switch (dwWaitStatus) {
        case WAIT_OBJECT_0:
            // More information is available about the change.
            printf("Change detected. Checking for more info...\n");

            // Normally, you would call FindNextChangeNotification here.
            // But for simplicity, we will just continue to wait.
            if (!FindNextChangeNotification(hDir)) {
                printf("FindNextChangeNotification failed (%d)\n", GetLastError());
                return 1;
            }
            break;
        case WAIT_TIMEOUT:
            // A timeout occurred, this would happen if we used a value other than INFINITE in WaitForSingleObject.
            printf("Timeout...\n");
            break;
        default:
            printf("Wait error...\n");
            break;
        }
    }

    if (FindCloseChangeNotification(hDir) == FALSE) {
        printf("FindCloseChangeNotification failed (%d)\n", GetLastError());
    }

    return 0;
}