HKEY hKey;\nLONG result = RegOpenKeyEx(HKEY_CURRENT_USER, TEXT("Software\\MyApp"), 0, KEY_READ, &hKey);\n\nif (result == ERROR_SUCCESS) {\n    // Perform operations with the registry key\n\n    // Close the handle when done\n    RegCloseKey(hKey);\n}\nelse {\n    // Handle the error\n}