#include <windows.h>\n#include <wintrust.h>\n#include <softpub.h>\n#include <tchar.h>\n#include <comdef.h>\n\n#pragma comment (lib, "wintrust.lib")\n\nBOOL IsDllSigned(LPCWSTR dllPath)\n{\n    LONG lStatus;\n    DWORD dwLastError;\n\n    // Initialize the structures.\n    WINTRUST_FILE_INFO FileData = {};\n    FileData.cbStruct = sizeof(WINTRUST_FILE_INFO);\n    FileData.pcwszFilePath = dllPath;\n\n    GUID WVTPolicyGUID = WINTRUST_ACTION_GENERIC_VERIFY_V2;\n\n    WINTRUST_DATA WinTrustData = {};\n    WinTrustData.cbStruct = sizeof(WinTrustData);\n    WinTrustData.dwUnionChoice = WTD_CHOICE_FILE;\n    WinTrustData.pFile = &FileData;\n    WinTrustData.dwUIChoice = WTD_UI_NONE;\n    WinTrustData.fdwRevocationChecks = WTD_REVOKE_NONE;\n    WinTrustData.dwStateAction = WTD_STATEACTION_VERIFY;\n    WinTrustData.dwProvFlags = WTD_SAFER_FLAG;\n    WinTrustData.pwszURLReference = NULL;\n\n    // Verify the file.\n    lStatus = WinVerifyTrust(NULL, &WVTPolicyGUID, &WinTrustData);\n\n    // Close the handle.\n    WinTrustData.dwStateAction = WTD_STATEACTION_CLOSE;\n    WinVerifyTrust(NULL, &WVTPolicyGUID, &WinTrustData);\n\n    return (lStatus == ERROR_SUCCESS);\n}\n\nHRESULT CreateSignedComInstance(LPCWSTR dllPath, REFCLSID clsid, REFIID iid, void** ppv)\n{\n    if (!IsDllSigned(dllPath))\n    {\n        return HRESULT_FROM_WIN32(ERROR_ACCESS_DENIED);\n    }\n\n    HMODULE hModule = LoadLibrary(dllPath);\n    if (!hModule)\n    {\n        return HRESULT_FROM_WIN32(GetLastError());\n    }\n\n    typedef HRESULT(__stdcall* DLLGETCLASSOBJECT)(REFCLSID, REFIID, LPVOID*);\n    DLLGETCLASSOBJECT DllGetClassObject = (DLLGETCLASSOBJECT)GetProcAddress(hModule, "DllGetClassObject");\n    if (!DllGetClassObject)\n    {\n        FreeLibrary(hModule);\n        return HRESULT_FROM_WIN32(GetLastError());\n    }\n\n    IClassFactory* pFactory = nullptr;\n    HRESULT hr = DllGetClassObject(clsid, IID_IClassFactory, (void**)&pFactory);\n    if (FAILED(hr))\n    {\n        FreeLibrary(hModule);\n        return hr;\n    }\n\n    hr = pFactory->CreateInstance(NULL, iid, ppv);\n    pFactory->Release();\n    FreeLibrary(hModule);\n\n    return hr;\n}