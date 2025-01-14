#include <stdio.h>
#include <windows.h>

int main() {
    HKEY hkey;
    DWORD dwType;
    DWORD dwSize = sizeof(DWORD);
    DWORD autorun;
    LONG errorCode;

    // Assuming you have already opened the registry key and retrieved the autorun value
    int newAutorun = (autorun - CD_AUTORUN_DISABLED);
    printf("New value: %d\n", newAutorun);
    errorCode = RegSetValueEx(hkey, TEXT("NoDriveTypeAutoRun"), 0, dwType, (LPBYTE) &autorun, dwSize);

    return 0;
}