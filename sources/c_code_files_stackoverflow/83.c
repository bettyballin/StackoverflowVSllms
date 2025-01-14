#include <Windows.h>
#include <stdio.h>

BOOL StopServiceCmd(const char *szServiceName)
{
    SC_HANDLE schService;
    SC_HANDLE schSCManager;
    SERVICE_STATUS ssStatus;       // current status of the service
    BOOL bRet;
    int iCont = 0;

    schSCManager = OpenSCManager(
        NULL, // machine (NULL == local)
        NULL, // database (NULL == default)
        SC_MANAGER_ALL_ACCESS // access required
    );
    if (schSCManager)
    {
        schService = OpenService(schSCManager, szServiceName, SERVICE_ALL_ACCESS);

        if (schService)
        {
            // try to stop the service
            if (ControlService(schService, SERVICE_CONTROL_STOP, &ssStatus))
            {
                Sleep(1000);

                while (QueryServiceStatus(schService, &ssStatus))
                {
                    iCont++;
                    if (ssStatus.dwCurrentState == SERVICE_STOP_PENDING)
                    {
                        Sleep(1000);
                        if (iCont > 4) break;
                    }
                    else
                        break;
                }

                if (ssStatus.dwCurrentState == SERVICE_STOPPED)
                    bRet = TRUE;
                else
                    bRet = FALSE;
            }

            CloseServiceHandle(schService);
        }
        else
            bRet = FALSE;

        CloseServiceHandle(schSCManager);
    }
    else
        bRet = FALSE;

    return bRet;
}

int main()
{
    // Example usage
    const char *serviceName = "your_service_name"; // Replace "your_service_name" with the name of the service you wish to stop.
    if (StopServiceCmd(serviceName))
    {
        printf("Service %s stopped successfully.\n", serviceName);
    }
    else
    {
        printf("Failed to stop service %s.\n", serviceName);
    }

    return 0;
}