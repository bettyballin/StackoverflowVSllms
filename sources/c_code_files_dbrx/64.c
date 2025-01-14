#include <windows.h>
#include <stdio.h>

int main() {
    // Initialize a named or unnamed event
    HANDLE hEvent = CreateEvent(NULL, TRUE, FALSE, NULL); // (name, manual reset, initial state, security)

    if (hEvent == NULL) {
        printf("CreateEvent failed: %d\n", GetLastError());
        return 1;
    }

    // In the main thread: wait on the event object
    while (true) { // Infinite loop. You might want to use appropriate condition for exit.
        DWORD result = WaitForSingleObject(hEvent, INFINITE); // Wait infinitely.
        if (result == WAIT_OBJECT_0) { // Event was set. Execute code related to event notification here.
            printf("Event signaled\n");
        } else { // An error occurred while waiting on the event object. Break and handle errors appropriately. Check GetLastError() for details about the specific error encountered.
            printf("WaitForSingleObject failed: %d\n", GetLastError());
            break;
        }
    }

    // In COM server: signal the main thread by setting the event when appropriate
    // This part should be in a separate thread or process
    // For demonstration purposes, we'll just set the event here
    BOOL success = SetEvent(hEvent); // Sets the hEvent state to signaled, and subsequently any threads blocked on a wait function calls return WAIT_OBJECT_0.
    if (!success) {
        printf("SetEvent failed: %d\n", GetLastError());
    }

    CloseHandle(hEvent);
    return 0;
}