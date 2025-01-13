#include <windows.h>\n#include <iostream>\n#include <string>\n\nbool IsTypeLibRegistered(const std::wstring& tlbGuid) {\n    HKEY hKey;\n    std::wstring regPath = L"SOFTWARE\\Classes\\TypeLib\\" + tlbGuid;\n\n    // Try to open the registry key\n    if (RegOpenKeyExW(HKEY_LOCAL_MACHINE, regPath.c_str(), 0, KEY_READ, &hKey) == ERROR_SUCCESS) {\n        RegCloseKey(hKey);\n        return true;\n    }\n    return false;\n}\n\nint main() {\n    // Replace with the actual GUID of your TLB file\n    std::wstring tlbGuid = L"{YOUR-TLB-GUID-HERE}";\n\n    if (IsTypeLibRegistered(tlbGuid)) {\n        std::wcout << L"TLB file is registered." << std::endl;\n    } else {\n        std::wcout << L"TLB file is not registered." << std::endl;\n    }\n\n    return 0;\n}