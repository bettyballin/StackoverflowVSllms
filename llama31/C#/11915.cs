using System.Security.Cryptography;\n\n// Encrypt data\nbyte[] data = Encoding.UTF8.GetBytes("Sensitive data");\nbyte[] encryptedData = ProtectedData.Protect(data, null, DataProtectionScope.CurrentUser);\n\n// Decrypt data\nbyte[] decryptedData = ProtectedData.Unprotect(encryptedData, null, DataProtectionScope.CurrentUser);\nstring decryptedString = Encoding.UTF8.GetString(decryptedData);