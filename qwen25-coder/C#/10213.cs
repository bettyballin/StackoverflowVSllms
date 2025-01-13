using System;\nusing System.Security.Cryptography;\nusing System.Text;\n\npublic class LicenseKeyGenerator\n{\n    private static byte[] key = Encoding.UTF8.GetBytes("YOUR_SECRET_KEY_HERE");\n    private static byte[] iv = Encoding.UTF8.GetBytes("YOUR_SECRET_IV_HERE");\n\n    public static string GenerateSerialNumber(string userId, DateTime expirationDate)\n    {\n        using (Aes aesAlg = Aes.Create())\n        {\n            aesAlg.Key = key;\n            aesAlg.IV = iv;\n\n            ICryptoTransform encryptor = aesAlg.CreateEncryptor(aesAlg.Key, aesAlg.IV);\n\n            using (var msEncrypt = new System.IO.MemoryStream())\n            {\n                using (var csEncrypt = new CryptoStream(msEncrypt, encryptor, CryptoStreamMode.Write))\n                {\n                    using (var swEncrypt = new System.IO.StreamWriter(csEncrypt))\n                    {\n                        string dataToEncrypt = $"{userId}|{expirationDate:s}";\n                        swEncrypt.Write(dataToEncrypt);\n                    }\n                    var encryptedBytes = msEncrypt.ToArray();\n                    return Convert.ToBase64String(encryptedBytes) + "-" +\n                           GenerateHash(encryptedBytes);\n                }\n            }\n        }\n    }\n\n    private static string GenerateHash(byte[] data)\n    {\n        using (var sha256 = SHA256.Create())\n        {\n            var hash = sha256.ComputeHash(data);\n            return Convert.ToBase64String(hash).Substring(0, 12); // Use a portion of the hash as key\n        }\n    }\n\n    public static bool ValidateSerialNumber(string serialNumber)\n    {\n        try\n        {\n            string[] parts = serialNumber.Split('-');\n            if (parts.Length != 2) return false;\n\n            byte[] encryptedData = Convert.FromBase64String(parts[0]);\n            string providedHash = parts[1];\n\n            using (Aes aesAlg = Aes.Create())\n            {\n                aesAlg.Key = key;\n                aesAlg.IV = iv;\n\n                ICryptoTransform decryptor = aesAlg.CreateDecryptor(aesAlg.Key, aesAlg.IV);\n\n                using (var msDecrypt = new System.IO.MemoryStream(encryptedData))\n                {\n                    using (var csDecrypt = new CryptoStream(msDecrypt, decryptor, CryptoStreamMode.Read))\n                    {\n                        using (var srDecrypt = new System.IO.StreamReader(csDecrypt))\n                        {\n                            string decryptedText = srDecrypt.ReadToEnd();\n                            var userIdAndExpirationDate = Convert.FromBase64String(parts[0]);\n                            string expectedHash = GenerateHash(userIdAndExpirationDate);\n\n                            return providedHash.Equals(expectedHash, StringComparison.Ordinal);\n                        }\n                    }\n                }\n            }\n        }\n        catch\n        {\n            return false;\n        }\n    }\n}