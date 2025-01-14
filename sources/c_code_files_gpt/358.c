#include <windows.h>

BOOL IsVCRuntimeInstalled() {
    HKEY hKey;
    LONG lRes;
    DWORD dwBufferSize = 32;
    DWORD dwValue;
    char szValue[32];

    lRes = RegOpenKeyEx(HKEY_LOCAL_MACHINE, "SOFTWARE\\Microsoft\\VisualStudio\\8.0\\VC\\VCRedist\\x86", 0, KEY_READ, &hKey);
    if (lRes != ERROR_SUCCESS) {
        return FALSE;
    }

    lRes = RegQueryValueEx(hKey, "Installed", NULL, NULL, (LPBYTE)szValue, &dwBufferSize);
    RegCloseKey(hKey);
    if (lRes != ERROR_SUCCESS) {
        return FALSE;
    }

    dwValue = atoi(szValue);
    if (dwValue == 1) {
        return TRUE;
    }

    return FALSE;
}