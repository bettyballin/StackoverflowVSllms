#include <Windows.h>
#include <string>

// Assuming TRegistry is a custom class, we'll define a basic implementation
class TRegistry {
public:
    HKEY RootKey;
    HKEY hKey;

    void OpenKey(const char* keyName, bool create) {
        RegOpenKeyEx(RootKey, keyName, 0, KEY_READ, &hKey);
        if (create && hKey == NULL) {
            RegCreateKeyEx(RootKey, keyName, 0, NULL, REG_OPTION_NON_VOLATILE, KEY_WRITE, NULL, &hKey, NULL);
        }
    }

    void ReadString(const char* paramName, std::string& defaultValue) {
        char buffer[1024];
        DWORD bufferSize = 1024;
        RegQueryValueEx(hKey, paramName, NULL, NULL, (LPBYTE)buffer, &bufferSize);
        defaultValue = buffer;
    }

    void CloseKey() {
        RegCloseKey(hKey);
    }
};

int main() {
    TRegistry* reg = new TRegistry();
    reg->RootKey = HKEY_CURRENT_USER; // Or whatever root you want to use
    reg->OpenKey("theKey", true);
    std::string defaultValue;
    reg->ReadString("theParam", defaultValue);
    reg->CloseKey();
    delete reg;
    return 0;
}