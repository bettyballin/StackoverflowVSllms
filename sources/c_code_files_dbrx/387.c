#include <windows.h>
#include <stdio.h>
#include <string.h>

// Define the missing types and structures
typedef enum _SC_ACTION_TYPE {
    SC_ACTION_NONE = 0,
    SC_ACTION_RESTART = 1,
    SC_ACTION_REBOOT = 2,
    SC_ACTION_RUN_COMMAND = 3,
    SC_ACTION_SHUTDOWN = 4
} SC_ACTION_TYPE;

typedef struct _SC_ACTION {
    SC_ACTION_TYPE Type;
    union {
        struct {
            LPWSTR lpCommand;
        } Run;
        struct {
            LPWSTR Text;
        } Text;
    } Data;
} SC_ACTION, *LPSC_ACTION;

typedef struct _SERVICE_FAILURE_ACTION {
    DWORD dwResetPeriod;
    LPWSTR lpRebootMsg;
    DWORD cActions;
    LPSC_ACTION lpCommand;
} SERVICE_FAILURE_ACTIONS, *LPSERVICE_FAILURE_ACTIONS;

// Forward declaration
void SetRecoveryOptions(SC_HANDLE schService);

int main() {
    // Create a service handle (replace with your actual service name)
    SC_HANDLE schService = OpenService(SC_MANAGER_CONNECT, "MyServiceName", GENERIC_READ);
    if (schService == NULL) {
        printf("Error opening service: %d\n", GetLastError());
        return 1;
    }

    SetRecoveryOptions(schService);

    CloseServiceHandle(schService);
    return 0;
}

void SetRecoveryOptions(SC_HANDLE schService) {
    DWORD bytesNeeded, error;
    SC_ACTION actions[3];
    LPSERVICE_FAILURE_ACTIONS pServiceFailureActions;

    // Setting up failure action and commands:
    actions[0].Type = SC_ACTION_RUN_COMMAND;
    wcscpy(actions[0].Data.Run.lpCommand, L"MyAppToStart.exe");

    actions[1].Type = SC_ACTION_REBOOT;
    wcscpy(actions[1].Data.Text.lpCommand, L"Rebooting");

    actions[2].Type = SC_ACTION_SHUTDOWN;
    wcscpy(actions[2].Data.Text.lpCommand, L"Shutting down");

    pServiceFailureActions = (LPSERVICE_FAILURE_ACTIONS) LocalAlloc(0, sizeof(SERVICE_FAILURE_ACTIONS) + sizeof(SC_ACTION)*2);
    pServiceFailureActions->cActions = 3;
    memcpy(pServiceFailureActions->lpCommand, actions, sizeof(SC_ACTION)*3);

    if (!ChangeServiceConfig2(schService, SERVICE_CONFIG_FAILURE_ACTIONS, (LPVOID)pServiceFailureActions)) {
        error = GetLastError();
        printf("Error changing recovery actions: %d\n", error);
    } else {
        printf("Recovery actions changed successfully\n");
        LocalFree(pServiceFailureActions); // Corrected the variable name
    }
}