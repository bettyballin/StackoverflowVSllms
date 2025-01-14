#include <windows.h>

int main() {
    HWND handle = GetDesktopWindow(); // Replace with the actual handle you want to use
    HWND foo = GetConsoleWindow(); // Replace with the actual handle you want to use
    SetWindowLong(handle, GWL_HWNDPARENT, (LONG)foo);
    return 0;
}