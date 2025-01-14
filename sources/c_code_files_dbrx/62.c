#include <windows.h>
#include <stdio.h>

int main() {
    HKEY hKey;
    LONG lRes = RegCreateKeyEx(HKEY_LOCAL_MACHINE, "SYSTEM\\CurrentControlSet\\Services\\Your Service Name", 0, NULL, REG_OPTION_NON_VOLATILE, KEY_ALL_ACCESS, NULL, &hKey, NULL);
    if (lRes != ERROR_SUCCESS) {
        printf("Error: RegCreateKeyEx failed\n");
        return lRes;
    }
    TCHAR szDependentService[] = "MSSQLSERVER"; // Modify this value accordingly.
    lRes = RegSetValueEx(hKey, "DependOnService", 0, REG_MULTI_SZ, (BYTE*) &szDependentService, sizeof(szDependentService));
    if (lRes != ERROR_SUCCESS) {
        printf("Error: RegSetValueEx failed\n");
    } else {
        printf("Successfully set dependent service for Your Service Name.\n");
    }
    RegCloseKey(hKey);
    return 0;
}