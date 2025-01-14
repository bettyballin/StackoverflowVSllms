#include <windows.h>
#include <stdio.h>

BOOL IsConsoleApp() {
    DWORD dwFlags;
    return GetConsoleProcessList((LPDWORD)NULL,&dwFlags);
}

int main()
{
    if(IsConsoleApp())
        printf("This is a console application.\n");
    else
        printf("This is a windowed (GUI) application.\n");
    return 0;
}