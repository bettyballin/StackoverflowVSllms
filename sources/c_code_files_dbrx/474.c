#include <windows.h>

void doSomeOperationA() {
    // your operation code here
}

int main() {
    HANDLE hReadPipe = CreateNamedPipe(TEXT("\\\\.\\pipe\\my_pipe"), 
                                       PIPE_ACCESS_INBOUND, 
                                       PIPE_TYPE_BYTE | PIPE_READMODE_BYTE | PIPE_WAIT, 
                                       1, 
                                       0, 
                                       0, 
                                       NMPWAIT_USE_DEFAULT_WAIT, 
                                       NULL);

    if (hReadPipe == INVALID_HANDLE_VALUE) {
        printf("CreateNamedPipe failed with error %d\n", GetLastError());
        return 1;
    }

    WaitForSingleObject(hReadPipe, INFINITE);  // Wait for B to send the signal
    doSomeOperationA();             // Process A operations after getting signal...
    CloseHandle(hReadPipe);      // No longer needed when you are done.

    return 0;
}