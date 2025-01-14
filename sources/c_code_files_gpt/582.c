#include <Windows.h>

int main() {
    HKEY hKey;
    LONG result = RegOpenKeyEx(HKEY_CURRENT_USER, TEXT("PathToKey"), 0, KEY_READ, &hKey);
    
    if (result != ERROR_SUCCESS) {
        // Handle error
        return 1;
    }
    
    DWORD type;
    DWORD dataSize = 1024;
    char data[1024];
    
    result = RegQueryValueEx(hKey, TEXT("ValueName"), NULL, &type, (LPBYTE)&data, &dataSize);
    
    if (result != ERROR_SUCCESS) {
        // Handle error
        RegCloseKey(hKey);
        return 1;
    }
    
    RegCloseKey(hKey);
    
    // Use the retrieved data
    return 0;
}