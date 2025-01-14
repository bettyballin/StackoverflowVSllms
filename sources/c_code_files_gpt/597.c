#include <Windows.h>
#include <stdio.h>

int main() {
    HKEY key;
    LPCWSTR s = L"Software\\YourPathHere"; // You need to specify the path
    HKEY resultKey;
    LONG result;

    // Assuming HKEY_CURRENT_USER as the root key for demonstration
    key = HKEY_CURRENT_USER;

    // The original line, slightly modified for clarity
    result = RegOpenKeyEx(key, s, 0, KEY_READ | KEY_WOW64_32KEY, &resultKey);

    if (result == ERROR_SUCCESS) {
        printf("Key opened successfully.\n");
        // Remember to close the key when you're done
        RegCloseKey(resultKey);
    } else {
        printf("Failed to open key: %ld\n", result);
    }

    return 0;
}