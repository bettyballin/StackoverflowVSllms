// Register application for .txt files\nHKEY hKey;\nRegCreateKeyEx(HKEY_CLASSES_ROOT, ".txt", 0, NULL, REG_OPTION_NON_VOLATILE, KEY_WRITE, NULL, &hKey, NULL);\nRegSetValueEx(hKey, NULL, 0, REG_SZ, (LPBYTE)"MyApp", strlen("MyApp") + 1);