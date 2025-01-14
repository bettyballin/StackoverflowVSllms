#include <windows.h>

// Define the missing function PumpMessage
void PumpMessage() {
    MSG msg;
    while (PeekMessage(&msg, NULL, 0, 0, PM_REMOVE)) {
        TranslateMessage(&msg);
        DispatchMessage(&msg);
    }
}

// Define the missing function OnIdle
int OnIdle(int nIdleCount) {
    // TO DO: implement your own idle processing here
    return 1; // return non-zero to continue idle processing
}

int main() {
    HANDLE ProcessInfo_hProcess; // define the process handle
    DWORD dwExitCode; // define the exit code
    int bWait = 1; // define the wait flag

    // Assume we have a process handle already
    ProcessInfo_hProcess = GetCurrentProcess();

    if (bWait)
    {
        // In order to allow updates of the GUI to happen while we're
        // waiting for the application to finish, we must run a message
        // pump here to allow messages to go through and get processed.
        LONG  nIdleCount = 0;
        for (;;)
        {
            MSG msg;
            if (PeekMessage(&msg, NULL, 0, 0, PM_NOREMOVE))
                PumpMessage();
            else //if (!OnIdle(nIdleCount++))
            {
                nIdleCount = 0;
                if (!PeekMessage(&msg, NULL, 0, 0, PM_NOREMOVE))
                {
                    DWORD nRes = MsgWaitForMultipleObjects(1, &ProcessInfo_hProcess,
                                                         FALSE, INFINITE, QS_ALLEVENTS);
                    if (nRes == WAIT_OBJECT_0)
                        break;
                }
            }
        }
    }
    GetExitCodeProcess(ProcessInfo_hProcess, &dwExitCode);

    return 0;
}