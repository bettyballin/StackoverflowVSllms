#include <windows.h>

int main()
{
    WinExec("notepad.exe", SW_SHOWNORMAL);
    return 0;
}