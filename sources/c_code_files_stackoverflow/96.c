#include <Windows.h>
#include <Shlwapi.h>

bool GetProcessName(LPWSTR pszProcessName, DWORD cchProcessName)
{
    bool success = false;
    // GetCurrentProcess() can't fail.
    DWORD cch = GetModuleFileName(NULL, pszProcessName, cchProcessName);
    if (cch > 0)
    {
        LPWSTR pszFileName = PathFindFileName(pszProcessName);
        if (pszFileName)
        {
            wmemmove(pszProcessName, pszFileName, lstrlen(pszFileName) + 1);
        }
        success = true;
    }
    return success;    
}

int main() {
    // example usage
    WCHAR processName[MAX_PATH];
    if (GetProcessName(processName, MAX_PATH)) {
        wprintf(L"Process name: %s\n", processName);
    }
    return 0;
}