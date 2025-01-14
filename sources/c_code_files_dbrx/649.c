#include <windows.h>
#include <stdio.h>

int main() {
    // CreateProcess function parameters
    STARTUPINFO startupInfo;
    PROCESS_INFORMATION processInformation;
    ZeroMemory(&startupInfo, sizeof(startupInfo));
    startupInfo.cb = sizeof(startupInfo);
    ZeroMemory(&processInformation, sizeof(processInformation));

    // Launch the child program
    if (!CreateProcessA("path\\to\\executable", "cmd line argument", NULL, NULL, TRUE, 0, NULL, NULL, &startupInfo, &processInformation)) {
        printf("Unable to create process: %d\n", GetLastError());
    } else {
        // Optionally wait for completion of the child program before exiting this one - not needed in your case since you just want to spawn another executable.
        WaitForSingleObject(processInformation.hProcess, INFINITE);
        CloseHandle(processInformation.hThread);
        CloseHandle(processInformation.hProcess); // Don't forget to close the process handle
    }

    return 0;
}