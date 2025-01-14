#include <windows.h>

int main() {
    HKEY key;
    LPCWSTR s = L"YourSubkeyName"; // Replace with your subkey name
    HKEY resultKey;
    LONG result;

    // Open the key
    result = RegOpenKeyEx(key, s, 0, KEY_READ | KEY_WOW64_64KEY, &resultKey);

    // Check the result
    if (result == ERROR_SUCCESS) {
        // Key opened successfully
        RegCloseKey(resultKey);
    } else {
        // Handle error
    }

    return 0;
}