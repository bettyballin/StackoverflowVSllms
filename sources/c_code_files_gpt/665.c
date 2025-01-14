#define _WIN32_WINNT 0x0600 // Define the Windows target version

#include <windows.h>
#include <tlhelp32.h>

BOOL IsProcessRunning(DWORD processID) {
    HANDLE hProcess = OpenProcess(PROCESS_QUERY_INFORMATION, FALSE, processID);
    if (hProcess == NULL) {
        return FALSE; // Process is not running
    }
    CloseHandle(hProcess);
    return TRUE; // Process is running
}

int main() {
    DWORD processID = 1234; // Replace with the actual process ID
    
    if (IsProcessRunning(processID)) {
        // Process 'A' is still running
        printf("Process %d is running.\n", processID);
    } else {
        // Process 'A' is not running
        printf("Process %d is not running.\n", processID);
    }

    return 0;
}