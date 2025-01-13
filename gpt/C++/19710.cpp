#include <windows.h>\n#include <iostream>\n#include <string>\n\nstd::string ReadRegistryValue(const std::string& fullPath) {\n    HKEY hKey;\n    DWORD dwType = REG_DWORD;\n    DWORD dwData;\n    DWORD dwDataSize = sizeof(dwData);\n    std::string result;\n\n    // Split the path into root key and subkey\n    size_t pos = fullPath.find('\\');\n    std::string rootKeyStr = fullPath.substr(0, pos);\n    std::string subKeyStr = fullPath.substr(pos + 1);\n\n    // Determine the root key\n    HKEY rootKey;\n    if (rootKeyStr == "HKEY_CURRENT_USER") {\n        rootKey = HKEY_CURRENT_USER;\n    } else {\n        // Handle other root keys as needed\n        std::cerr << "Unsupported root key." << std::endl;\n        return "";\n    }\n\n    // Open the registry key\n    if (RegOpenKeyEx(rootKey, subKeyStr.c_str(), 0, KEY_READ, &hKey) == ERROR_SUCCESS) {\n        // Read the registry value\n        if (RegGetValue(hKey, NULL, "SomeKey", RRF_RT_REG_DWORD, &dwType, &dwData, &dwDataSize) == ERROR_SUCCESS) {\n            result = std::to_string(dwData);\n        } else {\n            std::cerr << "Failed to read registry value." << std::endl;\n        }\n        RegCloseKey(hKey);\n    } else {\n        std::cerr << "Failed to open registry key." << std::endl;\n    }\n\n    return result;\n}\n\nbool WriteRegistryValue(const std::string& fullPath, DWORD value) {\n    HKEY hKey;\n    bool result = false;\n\n    // Split the path into root key and subkey\n    size_t pos = fullPath.find('\\');\n    std::string rootKeyStr = fullPath.substr(0, pos);\n    std::string subKeyStr = fullPath.substr(pos + 1);\n\n    // Determine the root key\n    HKEY rootKey;\n    if (rootKeyStr == "HKEY_CURRENT_USER") {\n        rootKey = HKEY_CURRENT_USER;\n    } else {\n        // Handle other root keys as needed\n        std::cerr << "Unsupported root key." << std::endl;\n        return false;\n    }\n\n    // Open the registry key\n    if (RegOpenKeyEx(rootKey, subKeyStr.c_str(), 0, KEY_WRITE, &hKey) == ERROR_SUCCESS) {\n        // Write the registry value\n        if (RegSetValueEx(hKey, "SomeKey", 0, REG_DWORD, reinterpret_cast<const BYTE*>(&value), sizeof(value)) == ERROR_SUCCESS) {\n            result = true;\n        } else {\n            std::cerr << "Failed to write registry value." << std::endl;\n        }\n        RegCloseKey(hKey);\n    } else {\n        std::cerr << "Failed to open registry key." << std::endl;\n    }\n\n    return result;\n}\n\nint main() {\n    std::string regPath = "HKEY_CURRENT_USER\\Software\\MyProgram";\n    std::string value = ReadRegistryValue(regPath);\n    std::cout << "The value is: " << value << std::endl;\n\n    if (WriteRegistryValue(regPath, 42)) {\n        std::cout << "Successfully wrote to the registry." << std::endl;\n    } else {\n        std::cerr << "Failed to write to the registry." << std::endl;\n    }\n\n    return 0;\n}