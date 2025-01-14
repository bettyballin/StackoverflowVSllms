#include <Windows.h>

#define REGISTRY_PATH "Software\\YourCompany\\YourApp"

int main() {
    HKEY hKey;
    LONG result = RegOpenKeyEx(HKEY_CURRENT_USER, REGISTRY_PATH, 0, KEY_READ | KEY_WRITE, &hKey);
    if (result == ERROR_SUCCESS) {
        /* work with hKey as needed */
        RegCloseKey(hKey); // Always ensure you call RegCloseKey to close opened keys.
    } else {
        // handle error
    }
    return 0;
}