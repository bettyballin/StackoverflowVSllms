#include <windows.h>
#include <stdio.h>

int main() {
    OVERLAPPED overlapped;
    // Initialize the OVERLAPPED structure
    overlapped.hEvent = CreateEvent(NULL, FALSE, FALSE, NULL);

    // Wait for the buffer to be filled or timeout
    int result = WaitForSingleObjectEx(overlapped.hEvent, 100, FALSE); // wait maximum of 100 ms
    if (result == WAIT_OBJECT_0) {
        printf("Non-empty Buffer!\n");
    } else if (GetLastError() == ERROR_TIMEOUT){
        printf("Empty or still empty buffer\n");
    }

    // Clean up
    CloseHandle(overlapped.hEvent);
    return 0;
}