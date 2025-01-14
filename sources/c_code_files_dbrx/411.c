#include <windows.h>

int main() {
    SC_HANDLE schSCManager;
    SC_HANDLE schService;

    // Open the Service Control Manager
    schSCManager = OpenSCManager(NULL, NULL, SC_MANAGER_CONNECT);

    // Create the service
    schService = CreateService(schSCManager, 
                               "Name", 
                               "SERVICE_NAME", 
                               SC_MANAGER_SECURITY_DESCRIPTOR, 
                               SERVICE_KERNEL_DRIVER | SERVICE_SYSTEM_START,
                               SERVICE_AUTO_START, 
                               SERVICE_ERROR_NORMAL, 
                               NULL, 
                               NULL, 
                               NULL, 
                               "LocalSystem\\SYSTEM", 
                               NULL);

    // Clean up
    if (schService != NULL) {
        CloseServiceHandle(schService);
    }
    if (schSCManager != NULL) {
        CloseServiceHandle(schSCManager);
    }

    return 0;
}