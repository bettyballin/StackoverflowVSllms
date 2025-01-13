#include <windows.h>\n#include <iostream>\n#include <string>\n#include <map>\n\nstd::wstring ConvertBinaryToPath(const BYTE* data, DWORD dataSize) {\n    std::wstring result;\n    for (DWORD i = 0; i < dataSize - 1; i += 2) { // Assume UTF-16 little-endian\n        wchar_t ch = static_cast<wchar_t>(data[i] | (data[i + 1] << 8));\n        if (!ch) break;\n        result += ch;\n    }\n    return result;\n}\n\nint main() {\n    HKEY hKey;\n    LONG result = RegOpenKeyEx(HKEY_LOCAL_MACHINE, L"SYSTEM\\MountedDevices", 0, KEY_READ, &hKey);\n    if (result != ERROR_SUCCESS) {\n        std::cerr << "Unable to open registry key.\n";\n        return 1;\n    }\n\n    std::map<wchar_t, std::wstring> driveToDevicePath;\n\n    for (DWORD i = 0; ; ++i) {\n        DWORD nameSize = MAX_PATH;\n        WCHAR name[MAX_PATH];\n        BYTE data[256];\n        DWORD dataSize;\n        DWORD type;\n\n        result = RegEnumValue(hKey, i, name, &nameSize, NULL, &type, data, &dataSize);\n\n        if (result == ERROR_NO_MORE_ITEMS) break;\n        else if (result != ERROR_SUCCESS) continue;\n\n        if (_wcsnicmp(name, L"\\DosDevices\\", 12) == 0 && type == REG_BINARY && name[14] >= 'A' && name[14] <= 'Z') {\n            WCHAR driveLetter = name[14];\n            std::wstring devicePath = ConvertBinaryToPath(data, dataSize);\n            if (!devicePath.empty()) {\n                driveToDevicePath[driveLetter] = devicePath;\n            }\n        }\n    }\n\n    RegCloseKey(hKey);\n\n    for (const auto& pair : driveToDevicePath) {\n        std::wcout << "Drive: " << pair.first << ": -> Device Path: " << pair.second.c_str() << std::endl;\n    }\n\n    return 0;\n}