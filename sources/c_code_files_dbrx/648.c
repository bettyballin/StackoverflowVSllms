#include <windows.h>
#include <stdio.h> // required for sprintf

#define BUF_LEN 1024 // define the buffer length

int main()
{
    LPVOID lpvoid;
    HANDLE hData = CreateFileMapping(
        INVALID_HANDLE_VALUE,// no other process requires access
        NULL,                  // reserved parameter, should be NULL
        PAGE_READWRITE,        // protection type
        0, BUF_LEN,            // size must be large enough for data transfer.
        (LPCWSTR) "Local\\SharedMemory" // shared mem name to share it between processes.
    );

    if (hData == NULL) {
        printf("CreateFileMapping failed with error %d\n", GetLastError());
        return 1;
    }

    lpvoid = MapViewOfFile(hData, FILE_MAP_ALL_ACCESS, 0, 0, BUF_LEN);// buffer created in memory for sharing data.

    if (lpvoid == NULL) {
        printf("MapViewOfFile failed with error %d\n", GetLastError());
        CloseHandle(hData);
        return 1;
    }

    sprintf((char *)lpvoid,"Shared Memory from C: Hello World"); //writing some data.

    // don't forget to release the resources
    UnmapViewOfFile(lpvoid);
    CloseHandle(hData);

    return 0;
}