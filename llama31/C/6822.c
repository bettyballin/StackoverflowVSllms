HKEY hKey;\nRegCreateKeyEx(HKEY_CURRENT_USER, L"Software\\YourCompany\\YourApp", 0, NULL, REG_OPTION_NON_VOLATILE, KEY_WRITE, NULL, &hKey, NULL);