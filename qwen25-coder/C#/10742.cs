string data = "SensitiveData";\nstring encryptedData = EncryptionHelper.EncryptString(data);\n\nstring regFileContent = $"Windows Registry Editor Version 5.00\n\n[HKEY_CURRENT_USER\\Software\\YourApp]\n\"EncryptedData\"=\"{encryptedData}\"";\n\n// Write to file\nFile.WriteAllText("settings.reg", regFileContent);