#include <windows.h>
#include <stdbool.h>

// Global context for thread state
BOOL gThreadAlive = FALSE; // Flag indicating whether your background thread is running
HANDLE gThreadHandle = NULL; // Handle of the worker thread (created upon request)

// Background work function (what you pass into CreateThread)
DWORD WINAPI HeavyFunction(LPVOID lpParam) {
    // Do heavy computing here... this runs in a separate thread.
    return 0; // Thread completion status/return value, if any
}

// Entrypoint to your EFB function
int YourEfbFunc() {
    if (gThreadAlive == FALSE) {
        gThreadHandle = CreateThread(NULL, 0, HeavyFunction, NULL, 0, NULL);
        if (!gThreadHandle || gThreadHandle == INVALID_HANDLE_VALUE) {
            return -1; // Error creating thread! Handle appropriately in your application.
        }
        gThreadAlive = TRUE;
        // You can also add WaitForMultipleObjects/WaitForSingleObject to check
        // the completion of this new thread (if your calling function expects a
        // result from HeavyFunction before proceeding). Make sure you handle
        // potential deadlock situations and don't forget to CloseHandle(gThreadHandle) if successful.
    } else {
        DWORD exitCode;
        GetExitCodeThread(gThreadHandle, &exitCode); // Get the current completion status of your worker thread.
        if (WaitForSingleObject(gThreadHandle, 0) == WAIT_OBJECT_0) {
            CloseHandle(gThreadHandle);
            gThreadHandle = NULL;
            gThreadAlive = FALSE;
            return -1; // Thread has ended with status exitCode. Handle appropriately!
        } else if (WaitForSingleObject(gThreadHandle, 0) == WAIT_TIMEOUT) {
            return DOEFB_BUSY;
        } else {
            // Unexpected result from WaitForSingleObject!! Make sure you handle this case in your application code...
            CloseHandle(gThreadHandle);
            gThreadHandle = NULL;
            gThreadAlive = FALSE;
            return -1; // Inform the calling function of an error! (or something)
        }
    }
    return 0; // some successful status or result value for YourEfbFunc ...
}