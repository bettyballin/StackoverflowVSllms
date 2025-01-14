#include <windows.h>

int main() {
    HKEY hKey;
    LONG result = RegOpenKeyEx(HKEY_CURRENT_USER, TEXT("Software\\MyApp"), 0, KEY_READ, &hKey);

    if (result == ERROR_SUCCESS) {
        // Perform operations with the registry key

        // Close the handle when done
        RegCloseKey(hKey);
    }
    else {
        // Handle the error
    }

    return 0;
}