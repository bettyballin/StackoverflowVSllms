#include <windows.h>

int main() {
    // Split command into executable and arguments
    char *szCommandLine[] = {"java", "-cp", "c:/dir/updates.jar;c:/dir/main.jar", "Main", NULL};

    STARTUPINFO startupInfo = {0};
    PROCESS_INFORMATION processInformation = {0};

    // Start the new process in detached mode, and wait for it to complete initializing before returning control to this application
    startupInfo.cb = sizeof(STARTUPINFO);
    CreateProcess("java", NULL, NULL, NULL, FALSE, CREATE_NEW_CONSOLE | DETACHED_PROCESS, NULL, NULL, &startupInfo, &processInformation);

    // You might want to add error checking here
    return 0;
}