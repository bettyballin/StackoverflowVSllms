pp
#include <Windows.h>
#include <iostream>

// Function to retrieve a string value from the registry
bool GetStringRegKey(HKEY hKey, const std::wstring& strValueName, std::wstring& strValue, const std::wstring& strDefaultValue)
{
    strValue = strDefaultValue;
    WCHAR szBuffer[512];
    DWORD dwBufferSize = sizeof(szBuffer);
    ULONG nError;
    nError = RegQueryValueExW(hKey, strValueName.c_str(), 0, NULL, (LPBYTE)szBuffer, &dwBufferSize);
    if (ERROR_SUCCESS == nError)
    {
        strValue = szBuffer;
        return true;
    }
    return false;
}

int main()
{
    HKEY hKey;
    LONG lRes = RegOpenKeyExW(HKEY_LOCAL_MACHINE, L"SOFTWARE\\Perl", 0, KEY_READ, &hKey);
    bool bExistsAndSuccess = (lRes == ERROR_SUCCESS);
    bool bDoesNotExistsSpecifically = (lRes == ERROR_FILE_NOT_FOUND);
    std::wstring strValueOfBinDir;
    std::wstring strKeyDefaultValue;
    GetStringRegKey(hKey, L"BinDir", strValueOfBinDir, L"bad");
    GetStringRegKey(hKey, L"", strKeyDefaultValue, L"bad");

    // Don't forget to close the registry key
    RegCloseKey(hKey);

    return 0;
}