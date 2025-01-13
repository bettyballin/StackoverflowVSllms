#include <windows.h>\n#include <objbase.h>\n\nSTDAPI DllRegisterServer() {\n    HKEY hKey;\n\n    // Create/Open the CLSID Key for your object.\n    if (ERROR_SUCCESS != RegCreateKey(HKEY_CLASSES_ROOT, TEXT("CLSID\\{Your-CLSID}"), &hKey))\n        return E_FAIL;\n    \n    // Set the description of your class\n    if (ERROR_SUCCESS != RegSetValue(hKey, NULL, REG_SZ, TEXT("Description of Your Class"), strlen(TEXT("Description of Your Class")) + 1))\n        return E_FAIL;\n\n    // Close CLSID Key for your object\n    RegCloseKey(hKey);\n\n    // Create/Open the InprocServer32 key under CLSID.\n    if (ERROR_SUCCESS != RegCreateKey(HKEY_CLASSES_ROOT, TEXT("CLSID\\{Your-CLSID}\\InprocServer32"), &hKey))\n        return E_FAIL;\n\n    // Set the path to your DLL\n    TCHAR szModulePath[MAX_PATH];\n    GetModuleFileName(NULL, szModulePath, MAX_PATH);\n    RegSetValue(hKey, NULL, REG_SZ, szModulePath, lstrlen(szModulePath));\n\n    // Close InprocServer32 key.\n    RegCloseKey(hKey);\n\n    // Register Interface (IAudioSessionEvents)\n    if (ERROR_SUCCESS != RegCreateKey(HKEY_CLASSES_ROOT, TEXT("Interface\\{IAudioSessionEvents-IID}"), &hKey))\n        return E_FAIL;\n    \n    // Normally, you would not set anything else for the interface key in DllRegisterServer\n    RegCloseKey(hKey);\n\n    return S_OK;\n}