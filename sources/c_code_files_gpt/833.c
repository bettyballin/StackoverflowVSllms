#include <windows.h>
#include <stdio.h>

void CreateNamedPipeServer()
{
    HANDLE hPipe;
    char buffer[1024];
    DWORD bytesRead;

    hPipe = CreateNamedPipe(TEXT("\\\\.\\pipe\\MyPipe"),
                                PIPE_ACCESS_DUPLEX,
                                PIPE_TYPE_MESSAGE | PIPE_READMODE_MESSAGE | PIPE_WAIT,
                                PIPE_UNLIMITED_INSTANCES,
                                1024, 1024, 0, NULL);

    if (hPipe == INVALID_HANDLE_VALUE)
    {
        printf("CreateNamedPipe failed, GLE=%d.\n", GetLastError());
        return;
    }

    BOOL isConnected = ConnectNamedPipe(hPipe, NULL) ? TRUE : (GetLastError() == ERROR_PIPE_CONNECTED);
    if (isConnected)
    {
        while (ReadFile(hPipe, buffer, sizeof(buffer) - 1, &bytesRead, NULL) != FALSE)
        {
            buffer[bytesRead] = '\0';
            printf("Received: %s\n", buffer);
        }
    }

    CloseHandle(hPipe);
}

int main() {
    CreateNamedPipeServer();
    return 0;
}