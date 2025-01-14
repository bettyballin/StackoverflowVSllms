#include <windows.h>
#include <stdio.h>

int main() {
    HANDLE hWritePipe = /* initialize your pipe handle here */ NULL;

    if (!WriteFile(hWritePipe, /*yourDataHere*/NULL, 0, /*lpNumberOfBytesWritten=*/NULL, /*lpOverlapped=*/NULL)) {
        printf("WriteFile failed (%d)\n", GetLastError());
    }
    CloseHandle(hWritePipe); // No longer needed when you are done.

    return 0;
}