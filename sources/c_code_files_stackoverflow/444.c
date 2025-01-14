#include <Windows.h>
#include <iostream>
#include <string>

using namespace std;

LONG GetDWORDRegKey(HKEY hKey, const wchar_t* strValueName, DWORD* nValue, DWORD nDefaultValue)
{
    *nValue = nDefaultValue;
    DWORD dwBufferSize = sizeof(DWORD);
    DWORD nResult = 0;
    LONG nError = RegQueryValueExW(hKey, strValueName, 0, NULL, (LPBYTE)&nResult, &dwBufferSize);
    if (ERROR_SUCCESS == nError)
    {
        *nValue = nResult;
    }
    return nError;
}

LONG GetBoolRegKey(HKEY hKey, const wchar_t* strValueName, bool* bValue, bool bDefaultValue)
{
    DWORD nDefValue = (bDefaultValue) ? 1 : 0;
    DWORD nResult = nDefValue;
    LONG nError = GetDWORDRegKey(hKey, strValueName, &nResult, nDefValue);
    if (ERROR_SUCCESS == nError)
    {
        *bValue = (nResult != 0) ? true : false;
    }
    return nError;
}

LONG GetStringRegKey(HKEY hKey, const wchar_t* strValueName, wchar_t* strValue, const wchar_t* strDefaultValue)
{
    wcscpy(strValue, strDefaultValue);
    WCHAR szBuffer[512];
    DWORD dwBufferSize = sizeof(szBuffer);
    ULONG nError;
    nError = RegQueryValueExW(hKey, strValueName, 0, NULL, (LPBYTE)szBuffer, &dwBufferSize);
    if (ERROR_SUCCESS == nError)
    {
        wcscpy(strValue, szBuffer);
    }
    return nError;
}

int main()
{
    HKEY hKey;
    LONG lRes = RegOpenKeyExW(HKEY_LOCAL_MACHINE, L"SOFTWARE\\Perl", 0, KEY_READ, &hKey);
    bool bExistsAndSuccess = (lRes == ERROR_SUCCESS);
    bool bDoesNotExistsSpecifically = (lRes == ERROR_FILE_NOT_FOUND);
    wchar_t strValueOfBinDir[512];
    wchar_t strKeyDefaultValue[512];
    GetStringRegKey(hKey, L"BinDir", strValueOfBinDir, L"bad");
    GetStringRegKey(hKey, L"", strKeyDefaultValue, L"bad");

    return 0;
}