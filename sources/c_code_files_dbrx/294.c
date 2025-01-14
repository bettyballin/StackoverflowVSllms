#include <windows.h>
#include <stdbool.h>

bool RegValueExists(HKEY hKey, LPCTSTR lpSubKey, LPTSTR lpName) {
    bool isValid;
    HKEY keyHandle = 0;
    DWORD dwSize, type;

    // Open registry key
    if (RegOpenKeyEx(hKey, lpSubKey, 0, KEY_READ | KEY_WOW64_64KEY, &keyHandle) == ERROR_SUCCESS) {
        RegQueryValueEx(keyHandle, lpName, 0, &type, NULL, &dwSize); //check if the value exists and get data size.
        isValid = dwSize ? true : false;
    } else {
        isValid = false;
    }

    if (keyHandle != NULL) RegCloseKey(keyHandle);  //close handle to registry key.
    return isValid;
}

int main() {
    // Example usage
    HKEY hKey = HKEY_CURRENT_USER;
    LPCTSTR lpSubKey = TEXT("Software\\Microsoft\\Windows\\CurrentVersion\\Run");
    LPTSTR lpName = TEXT("SomeValue");

    bool exists = RegValueExists(hKey, lpSubKey, lpName);
    if (exists) {
        printf("Value exists\n");
    } else {
        printf("Value does not exist\n");
    }

    return 0;
}