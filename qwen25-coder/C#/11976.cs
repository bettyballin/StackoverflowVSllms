using System;\nusing Microsoft.Win32;\nusing System.Security.Cryptography;\n\npublic class MyDatabaseDataContext : DatabaseDataContext\n{\n    public MyDatabaseDataContext()\n        : base(DecryptConnectionString())\n    {\n    }\n\n    private static string DecryptConnectionString()\n    {\n        // Registry path where the encrypted connection string is stored\n        const string registryPath = @"SOFTWARE\MyCompany\MyApp\Settings";\n        \n        using (RegistryKey key = Registry.LocalMachine.OpenSubKey(registryPath))\n        {\n            if (key != null)\n            {\n                // Retrieve the encrypted data\n                byte[] encryptedConnectionString = (byte[])key.GetValue("EncryptedDSN");\n\n                // Decrypt the connection string\n                return Decrypt(encryptedConnectionString);\n            }\n            throw new Exception("Registry key not found");\n        }\n    }\n\n    private static string Decrypt(byte[] cipherText)\n    {\n        using (Aes aesAlg = Aes.Create())\n        {\n            // Use your encryption key and IV here; keys must match for decryption\n            byte[] keyBytes = { /* your 16-byte or 32-byte key */ };\n            byte[] ivBytes = { /* your 16-byte IV */ };\n\n            aesAlg.Key = keyBytes;\n            aesAlg.IV = ivBytes;\n\n            ICryptoTransform decryptor = aesAlg.CreateDecryptor(aesAlg.Key, aesAlg.IV);\n\n            using (var msDecrypt = new System.IO.MemoryStream(cipherText))\n            {\n                using (var csDecrypt = new CryptoStream(msDecrypt, decryptor, CryptoStreamMode.Read))\n                {\n                    using (var srDecrypt = new System.IO.StreamReader(csDecrypt))\n                    {\n                        return srDecrypt.ReadToEnd();\n                    }\n                }\n            }\n        }\n    }\n}