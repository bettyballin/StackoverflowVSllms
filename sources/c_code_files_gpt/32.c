#include <Windows.h>
#include <stdio.h>

int main() {
    HANDLE hEvent = CreateEvent(NULL, FALSE, FALSE, TEXT("testevt"));
    if (hEvent == NULL) {
        // handle error
        printf("Error creating event: %d\n", GetLastError());
        return 1;
    }

    // Log thread ID and event creation
    printf("Thread #%d created event 'testevt'.\n", GetCurrentThreadId());

    // Signal the event
    SetEvent(hEvent);

    // Log thread ID and event signaling
    printf("Thread #%d signaled event 'testevt'.\n", GetCurrentThreadId());

    CloseHandle(hEvent);
    return 0;
}