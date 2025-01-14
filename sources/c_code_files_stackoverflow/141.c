#include <windows.h>
#include <stdio.h>

int main()
{
    HANDLE hFile, hStream;
    DWORD dwRet;

    hFile = CreateFileA("testfile", GENERIC_WRITE, FILE_SHARE_WRITE, NULL, OPEN_ALWAYS, 0, NULL);
    if (hFile == INVALID_HANDLE_VALUE)
        printf("Cannot open testfile\n");
    else
    {
        WriteFile(hFile, "This is testfile", 16, &dwRet, NULL);
        CloseHandle(hFile);
    }

    hStream = CreateFileA("testfile:stream", GENERIC_WRITE, FILE_SHARE_WRITE, NULL, OPEN_ALWAYS, 0, NULL);
    if (hStream == INVALID_HANDLE_VALUE)
        printf("Cannot open testfile:stream\n");
    else
    {
        WriteFile(hStream, "This is testfile:stream", 23, &dwRet, NULL);
        CloseHandle(hStream);
    }

    return 0;
}