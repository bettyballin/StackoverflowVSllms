// Use DPAPI to store sensitive data\nbyte[] encryptedData = ProtectedData.Protect(myData, null, DataProtectionScope.CurrentUser);