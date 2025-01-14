#include <windows.h>
#include <stdio.h>

BOOL CanWriteToRegistryKey(HKEY hKey, LPCSTR subKey) {
    HKEY hTestKey;
    LONG lResult;
    
    // Attempt to open the registry key with write access
    lResult = RegOpenKeyEx(hKey, subKey, 0, KEY_WRITE, &hTestKey);
    
    if (lResult == ERROR_SUCCESS) {
        // Successfully opened with write access
        RegCloseKey(hTestKey);
        return TRUE;
    }
    
    return FALSE;
}

int main() {
    // Check write access to HKEY_LOCAL_MACHINE
    if (CanWriteToRegistryKey(HKEY_LOCAL_MACHINE, "SOFTWARE\\Test")) {
        printf("Can write to HKEY_LOCAL_MACHINE\\SOFTWARE\\Test\n");
    } else {
        printf("Cannot write to HKEY_LOCAL_MACHINE\\SOFTWARE\\Test\n");
    }

    // Check write access to HKEY_CURRENT_USER policy keys
    if (CanWriteToRegistryKey(HKEY_CURRENT_USER, "Software\\Policies")) {
        printf("Can write to HKEY_CURRENT_USER\\Software\\Policies\n");
    } else {
        printf("Cannot write to HKEY_CURRENT_USER\\Software\\Policies\n");
    }

    return 0;
}