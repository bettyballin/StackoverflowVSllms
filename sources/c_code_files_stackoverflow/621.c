#include <windows.h>

int main() {
    HKEY hKey;
    LONG result = RegOverridePredefKey(HKEY_CLASSES_ROOT, &hKey);
    if (result == ERROR_SUCCESS) {
        printf("Registry key overridden successfully\n");
        // Don't forget to close the handle when you're done with it
        RegCloseKey(hKey);
    } else {
        printf("Failed to override registry key. Error code: %ld\n", result);
    }
    return 0;
}