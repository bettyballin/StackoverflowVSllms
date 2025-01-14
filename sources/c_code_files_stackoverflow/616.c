#include <windows.h>

BOOL IsProcessRunning(HANDLE process)
{
    return WaitForSingleObject(process, 0) != WAIT_OBJECT_0;
}

void WaitForProcessToExit(HANDLE process)
{
    WaitForSingleObject(process, INFINITE);
}

int main() {
    // Example usage:
    HANDLE process = CreateProcess(NULL, "example.exe", NULL, NULL, FALSE, 0, NULL, NULL, NULL, NULL);
    if (process != NULL) {
        if (IsProcessRunning(process)) {
            printf("Process is running\n");
        } else {
            printf("Process is not running\n");
        }
        WaitForProcessToExit(process);
        CloseHandle(process);
    }
    return 0;
}