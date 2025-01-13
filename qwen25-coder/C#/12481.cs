using System.Security.Cryptography;\nusing System.Text;\n\npublic void SaveToken(string token)\n{\n    byte[] data = Encoding.UTF8.GetBytes(token);\n    byte[] encryptedData = ProtectedData.Protect(data, null, DataProtectionScope.CurrentUser);\n    \n    // Store the encryptedData in a file or database securely.\n}\n\npublic string LoadToken()\n{\n    // Retrieve the stored encryptedData from your storage\n    byte[] encryptedData = ...;\n\n    byte[] decryptedData = ProtectedData.Unprotect(encryptedData, null, DataProtectionScope.CurrentUser);\n    return Encoding.UTF8.GetString(decryptedData);\n}