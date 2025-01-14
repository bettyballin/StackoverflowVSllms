#include <windows.h>

int main() {
    HANDLE hSlot;

    // Create mail slot in local process to send or receive messages from remote thread
    hSlot = CreateMailslot(TEXT("\\\\.\\mailslot\\temp"), 0, MAILSLOT_WAIT_FOREVER, NULL);

    // You should check the return value of CreateMailslot to ensure it was successful.
    if (hSlot == INVALID_HANDLE_VALUE) {
        // Handle the error
        return 1;
    }

    // Your code here...

    // Don't forget to close the handle when you're done with it
    CloseHandle(hSlot);

    return 0;
}