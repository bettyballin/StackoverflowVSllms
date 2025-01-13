using System;\nusing System.IO;\nusing System.Security.Cryptography;\nusing System.Text;\n\npublic class EncryptionHelper\n{\n    public static string Encrypt(string plainText, byte[] Key, byte[] IV)\n    {\n        if (plainText == null || plainText.Length <= 0)\n            throw new ArgumentNullException("plainText");\n        if (Key == null || Key.Length <= 0)\n            throw new ArgumentNullException("Key");\n        if (IV == null || IV.Length <= 0)\n            throw new ArgumentNullException("IV");\n\n        byte[] encrypted;\n\n        using (Aes aesAlg = Aes.Create())\n        {\n            aesAlg.Key = Key;\n            aesAlg.IV = IV;\n\n            ICryptoTransform encryptor = aesAlg.CreateEncryptor(aesAlg.Key, aesAlg.IV);\n\n            using (MemoryStream msEncrypt = new MemoryStream())\n            {\n                using (CryptoStream csEncrypt = new CryptoStream(msEncrypt, encryptor, CryptoStreamMode.Write))\n                {\n                    using (StreamWriter swEncrypt = new StreamWriter(csEncrypt))\n                    {\n                        swEncrypt.Write(plainText);\n                    }\n                    encrypted = msEncrypt.ToArray();\n                }\n            }\n        }\n        return Convert.ToBase64String(encrypted);\n    }\n\n    public static string Decrypt(string cipherText, byte[] Key, byte[] IV)\n    {\n        if (cipherText == null || cipherText.Length <= 0)\n            throw new ArgumentNullException("cipherText");\n        if (Key == null || Key.Length <= 0)\n            throw new ArgumentNullException("Key");\n        if (IV == null || IV.Length <= 0)\n            throw new ArgumentNullException("IV");\n\n        string plaintext = null;\n\n        using (Aes aesAlg = Aes.Create())\n        {\n            aesAlg.Key = Key;\n            aesAlg.IV = IV;\n\n            ICryptoTransform decryptor = aesAlg.CreateDecryptor(aesAlg.Key, aesAlg.IV);\n\n            using (MemoryStream msDecrypt = new MemoryStream(Convert.FromBase64String(cipherText)))\n            {\n                using (CryptoStream csDecrypt = new CryptoStream(msDecrypt, decryptor, CryptoStreamMode.Read))\n                {\n                    using (StreamReader srDecrypt = new StreamReader(csDecrypt))\n                    {\n                        plaintext = srDecrypt.ReadToEnd();\n                    }\n                }\n            }\n        }\n        return plaintext;\n    }\n}