#include <windows.h>\n#include <sddl.h>\n#include <aclapi.h>\n#include <iostream>\n\nvoid SetRegistryKeyPermissions(HKEY hKeyRoot, LPCWSTR subKey) {\n    HKEY hKey;\n    if (RegOpenKeyEx(hKeyRoot, subKey, 0, WRITE_DAC | KEY_READ, &hKey) != ERROR_SUCCESS) {\n        std::wcerr << L"Failed to open registry key." << std::endl;\n        return;\n    }\n\n    EXPLICIT_ACCESS ea;\n    PACL pOldDACL = NULL, pNewDACL = NULL;\n    PSECURITY_DESCRIPTOR pSD = NULL;\n\n    if (GetSecurityInfo(hKey, SE_REGISTRY_KEY, DACL_SECURITY_INFORMATION, NULL, NULL, &pOldDACL, NULL, &pSD) != ERROR_SUCCESS) {\n        std::wcerr << L"Failed to get security info." << std::endl;\n        RegCloseKey(hKey);\n        return;\n    }\n\n    ZeroMemory(&ea, sizeof(EXPLICIT_ACCESS));\n    ea.grfAccessPermissions = KEY_ALL_ACCESS;\n    ea.grfAccessMode = SET_ACCESS;\n    ea.grfInheritance = NO_INHERITANCE;\n    ea.Trustee.TrusteeForm = TRUSTEE_IS_NAME;\n    ea.Trustee.TrusteeType = TRUSTEE_IS_USER;\n    ea.Trustee.ptstrName = L"CURRENT_USER";\n\n    if (SetEntriesInAcl(1, &ea, pOldDACL, &pNewDACL) != ERROR_SUCCESS) {\n        std::wcerr << L"Failed to set entries in ACL." << std::endl;\n        if (pSD) LocalFree(pSD);\n        RegCloseKey(hKey);\n        return;\n    }\n\n    if (SetSecurityInfo(hKey, SE_REGISTRY_KEY, DACL_SECURITY_INFORMATION, NULL, NULL, pNewDACL, NULL) != ERROR_SUCCESS) {\n        std::wcerr << L"Failed to set security info." << std::endl;\n    } else {\n        std::wcout << L"ACL changed successfully." << std::endl;\n    }\n\n    if (pSD) LocalFree(pSD);\n    if (pNewDACL) LocalFree(pNewDACL);\n    RegCloseKey(hKey);\n}\n\nint main() {\n    LPCWSTR subKey = L"SOFTWARE\\YourSubKey";\n    SetRegistryKeyPermissions(HKEY_CURRENT_USER, subKey);\n    return 0;\n}