#include <windows.h>
#include <string.h>

int main() {
    #define MAX_BUFFER 144 // replace with your real maximum size requirement
    char buffer[MAX_BUFFER];
    memset(buffer, 0, sizeof(buffer));       // initialize the array
    DWORD regDataSize = sizeof(buffer);      // get the size of required data from registry

    HKEY hKey; // You need to open the registry key before using it
    RegOpenKeyEx(HKEY_CURRENT_USER, "Your\\Registry\\Key", 0, KEY_READ, &hKey);

    LPCWSTR lpValueName = L"YourValueName"; // You need to specify the value name

    LONG result = RegQueryValueEx(
        hKey,                           // a handle to an open key
        lpValueName,                  // address of value name (for example, "App")
        0, NULL, (LPBYTE) buffer                // buffer used for the copy operation.
    );

    RegCloseKey(hKey); // Close the registry key after use

    if(result == ERROR_SUCCESS) {
        // data was successfully read into 'buffer'. Ensure its length does not exceed MAX_BUFFER by checking against `regDataSize` before using it.
    } else {
        // handle error accordingly: RegQueryValueEx failed
    }

    return 0;
}