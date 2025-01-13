HKEY hKey;\nLPCTSTR sk = TEXT("SOFTWARE\\TestSoftware");\n\nLONG openRes = RegOpenKeyEx(HKEY_CURRENT_USER, sk, 0, KEY_ALL_ACCESS, &hKey);\n\nif (openRes == ERROR_SUCCESS) {\n    printf("Success opening key.");\n} else {\n    printf("Error opening key: %d", openRes);\n}\n\nLPCTSTR value = TEXT("TestSoftwareKey");\nLPCTSTR data = TEXT("TestData");\n\nLONG setRes = RegSetValueEx(hKey, value, 0, REG_SZ, (LPBYTE)data, (lstrlen(data) + 1) * sizeof(TCHAR));\n\nif (setRes == ERROR_SUCCESS) {\n    printf("Success writing to Registry.");\n} else {\n    printf("Error writing to Registry: %d", setRes);\n}\n\nLONG closeOut = RegCloseKey(hKey);\n\nif (closeOut == ERROR_SUCCESS) {\n    printf("Success closing key.");\n} else {\n    printf("Error closing key: %d", closeOut);\n}