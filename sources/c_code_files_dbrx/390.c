#include <windows.h>

int main() {
    HANDLE hEvent = CreateEvent(NULL, FALSE, FALSE, NULL); // manual reset & initially non-signaled (state)
    WaitForSingleObject(hEvent, INFINITE); // the wait returns when event is signalled by SetEvent()
    ResetEvent(hEvent);  // optionally, set this to manually indicate a new wait if necessary.
    CloseHandle(hEvent); // close the handle to avoid resource leaks
    return 0;
}