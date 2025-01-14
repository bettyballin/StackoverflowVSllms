#include <Windows.h>

int main() {
    HKEY key;
    LONG err = RegOpenKeyEx(HKEY_CURRENT_USER, "SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Run", 0, KEY_READ|KEY_WRITE, &key);
    if(err) {
        // Test err to see if its a permission error. if so, the user does not have permission.
        if(err == ERROR_ACCESS_DENIED) {
            printf("Permission denied\n");
        } else {
            printf("Error opening key: %ld\n", err);
        }
    } else {
        RegCloseKey(key);
    }
    return 0;
}