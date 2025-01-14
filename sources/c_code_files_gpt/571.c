#include <windows.h>
#include <stdio.h>
#include <tchar.h>

int main() {
    HKEY hKey;
    LPCTSTR sk = TEXT("SOFTWARE\\TestSoftware");

    // Open the key
    LONG openRes = RegOpenKeyEx(HKEY_LOCAL_MACHINE, sk, 0, KEY_ALL_ACCESS, &hKey);

    if (openRes == ERROR_SUCCESS) {
        _tprintf(TEXT("Success opening key.\n"));
    } else {
        _tprintf(TEXT("Error opening key: %ld\n"), openRes);
        return 1;  // Exit if the key couldn't be opened
    }

    // Define the value name and data
    LPCTSTR value = TEXT("TestSoftwareKey");
    LPCTSTR data = TEXT("TestData");

    // Set the value in the registry
    LONG setRes = RegSetValueEx(hKey, value, 0, REG_SZ, (const BYTE*)data, (_tcslen(data) + 1) * sizeof(TCHAR));

    if (setRes == ERROR_SUCCESS) {
        _tprintf(TEXT("Success writing to Registry.\n"));
    } else {
        _tprintf(TEXT("Error writing to Registry: %ld\n"), setRes);
    }

    // Close the key
    LONG closeOut = RegCloseKey(hKey);

    if (closeOut == ERROR_SUCCESS) {
        _tprintf(TEXT("Success closing key.\n"));
    } else {
        _tprintf(TEXT("Error closing key: %ld\n"), closeOut);
    }

    return 0;
}