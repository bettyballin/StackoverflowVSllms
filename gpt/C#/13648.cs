using System;\nusing System.IO;\nusing System.Security.Cryptography;\nusing System.Text;\n\npublic class DataProtection\n{\n    public static void Main()\n    {\n        string data = "Sensitive data to be protected.";\n        string filePath = "protectedData.dat";\n\n        // Encrypt data\n        byte[] encryptedData = ProtectedData.Protect(Encoding.UTF8.GetBytes(data), null, DataProtectionScope.CurrentUser);\n\n        // Save to file\n        File.WriteAllBytes(filePath, encryptedData);\n\n        // Read from file and decrypt\n        byte[] readEncryptedData = File.ReadAllBytes(filePath);\n        byte[] decryptedData = ProtectedData.Unprotect(readEncryptedData, null, DataProtectionScope.CurrentUser);\n\n        // Output decrypted data\n        Console.WriteLine(Encoding.UTF8.GetString(decryptedData));\n    }\n}