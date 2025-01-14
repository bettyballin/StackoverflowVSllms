#include <windows.h>

int main() {
    // Assuming win32window and formhandle are defined or retrieved somewhere in your actual code
    HWND win32window = /* initialize or retrieve your window handle */;
    HWND formhandle = /* initialize or retrieve your parent form handle */;

    if (!SetWindowLongPtr(win32window, GWLP_HWNDPARENT, (LONG_PTR)formhandle)) {
        // Handle the error, for example, print the last error code
        DWORD errorCode = GetLastError();
        printf("Failed to set the parent window. Error code: %d\n", errorCode);
        return 1; // Return a non-zero value to indicate failure
    }

    return 0; // Return zero to indicate success
}