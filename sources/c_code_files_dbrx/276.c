#include <windows.h>

int main() {
    HANDLE event;
    OVERLAPPED overlapped;

    // Create an Event object and an overlapped structure, both initialized
    event = CreateEvent(NULL, FALSE, FALSE, NULL);
    overlapped.hEvent = event;

    return 0;
}