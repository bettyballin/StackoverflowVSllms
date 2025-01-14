#include <Windows.h>

int main() {
    HKEY key;
    DWORD dwData = 0; // You need to initialize dwData with some value

    if(ERROR_SUCCESS == RegOpenKeyEx(HKEY_LOCAL_MACHINE, "System\\CurrentControlSet\\Control\\Power\\Timeouts", 0, KEY_SET_VALUE, &key))
    {
        if(RegSetValueEx(key, "BattSuspendTimeout", 0, REG_DWORD, (LPBYTE)&dwData, sizeof(DWORD)))
        {
            RegCloseKey(key);
            return FALSE;
        }

        RegCloseKey(key);
    }
    return TRUE;
}