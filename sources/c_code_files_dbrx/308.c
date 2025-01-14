#include <windows.h>
#include <stdio.h>
#include <tchar.h>

int main() {
    HKEY hKey;
    LPCTSTR sk = TEXT("SOFTWARE\\TestSoftware");

    LONG openRes = RegOpenKeyEx(HKEY_LOCAL_MACHINE, sk, 0, KEY_ALL_ACCESS , &hKey);

    if (openRes == ERROR_SUCCESS) {             // Check for error
        printf("Success opening key.\n");
    } else {
        printf("Error opening key. Error code: %lu\n", openRes);  // Print the specific error code
    }

    LPCTSTR value = TEXT("TestSoftwareKey");      // REG_SZ value types should be in TCHAR
    LPTSTR data = _tcsdup(TEXT("TestData"));     // Allocate memory for unicode string

    LONG setRes = RegSetValueEx (hKey, value, 0, REG_SZ, (LPBYTE)data, (_tcslen(data)+1)*sizeof(TCHAR));
                   // Add sizeof(TCHAR), because the function takes length in bytes.

    if (setRes == ERROR_SUCCESS) {              // Check for error
        printf("Success writing to Registry.\n");
    } else {
        printf("Error writing to Registry. Error code: %lu\n", setRes);  // Print the specific error code
    }

    LONG closeOut = RegCloseKey(hKey);

    if (closeOut == ERROR_SUCCESS) {            // Check for error and print it
        printf("Success closing key.\n");
    } else {
        printf("Error closing key. Error code: %lu\n", closeOut);
    }

    free(data);  // Remember to deallocate the memory!
    return 0;
}