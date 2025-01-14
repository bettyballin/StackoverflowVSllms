#include <stdio.h>
#include <windows.h>

int separate_console(void)
{
    CONSOLE_SCREEN_BUFFER_INFO csbi;

    if (!GetConsoleScreenBufferInfo(GetStdHandle(STD_OUTPUT_HANDLE), &csbi))
    {
        printf("GetConsoleScreenBufferInfo failed: %lu\n", GetLastError());
        return FALSE;
    }

    // if cursor position is (0,0) then we were launched in a separate console
    return ((!csbi.dwCursorPosition.X) && (!csbi.dwCursorPosition.Y));
}

int main()
{
    int result = separate_console();
    printf("Separate console: %s\n", result ? "TRUE" : "FALSE");
    return 0;
}