#include <windows.h>

int WINAPI WinMain(HINSTANCE hInstance, HINSTANCE hPrevInstance, LPSTR lpCmdLine, int nCmdShow)
{
    // execl is a POSIX function, not available on Windows. We'll use the Windows equivalent.
    // Here we're using CreateProcess to launch notepad.exe
    STARTUPINFO si;
    PROCESS_INFORMATION pi;

    ZeroMemory(&si, sizeof(si));
    si.cb = sizeof(si);
    ZeroMemory(&pi, sizeof(pi));

    CreateProcess(NULL, "C:\\Windows\\notepad.exe", NULL, NULL, FALSE, 0, NULL, NULL, &si, &pi);
    return 0;
}