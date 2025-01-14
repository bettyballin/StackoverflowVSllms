#include <windows.h>
#include <stdio.h>

int main() {
    HKEY key;
    const char *s = "SOFTWARE\\YourKey"; // replace with your key path
    LONG result = RegOpenKeyEx(HKEY_LOCAL_MACHINE, s, 0, (KEY_READ | KEY_WOW64_32KEY), &key);
    if (result == ERROR_SUCCESS) {
        // ... read the key here ...
        RegCloseKey(key);
    } else {
        printf("Error opening key: %ld\n", result);
    }
    return 0;
}