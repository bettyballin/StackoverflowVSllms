#include <windows.h>

int main() {
    HANDLE hObject = CreateEvent(NULL, FALSE, FALSE, NULL);
    DWORD dwMilliseconds = 1000; // wait for 1 second

    if (hObject == NULL) {
        // Handle error
        return 1;
    }

    DWORD result = WaitForSingleObject(hObject, dwMilliseconds);

    if (result == WAIT_OBJECT_0) {
        // The event is signaled
    } else if (result == WAIT_TIMEOUT) {
        // The wait timed out
    } else if (result == WAIT_FAILED) {
        // The wait failed
        DWORD error = GetLastError();
        // Handle error
    }

    CloseHandle(hObject);
    return 0;
}