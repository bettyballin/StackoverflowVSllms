#include <Windows.h>

int main() {
    HANDLE hWritePipe = NULL;
    HANDLE hReadPipe = NULL;

    // Assuming you have initialized hWritePipe and hReadPipe somewhere in your code

    if (hWritePipe) CloseHandle(hWritePipe);  // Close the write end of the pipe before exiting.
    if (hReadPipe) CloseHandle(hReadPipe);   // Close the read end of the pipe before exiting.

    return 0;
}