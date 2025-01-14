#include <windows.h>

int main() {
    HANDLE hEvent = CreateEvent(NULL, TRUE, FALSE, TEXT("MyEvent")); // Manual-reset event

    // Signal the event
    SetEvent(hEvent);

    // Wait for the event
    WaitForSingleObject(hEvent, INFINITE);

    return 0;
}