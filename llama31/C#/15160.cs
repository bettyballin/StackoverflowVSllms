using System;\nusing System.IO;\nusing System.Security.Cryptography;\nusing System.Text;\n\npublic class ConfigEncryptor\n{\n    private static byte[] _key = { 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09, 0x10, 0x11, 0x12, 0x13, 0x14, 0x15, 0x16 };\n    private static byte[] _iv = { 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09, 0x10, 0x11, 0x12, 0x13, 0x14, 0x15, 0x16 };\n\n    public static void EncryptConfig(string configFile)\n    {\n        string clearText = File.ReadAllText(configFile);\n        byte[] encryptedBytes = EncryptString(clearText, _key, _iv);\n        File.WriteAllBytes(configFile, encryptedBytes);\n    }\n\n    public static void DecryptConfig(string configFile)\n    {\n        byte[] encryptedBytes = File.ReadAllBytes(configFile);\n        string clearText = DecryptString(encryptedBytes, _key, _iv);\n        File.WriteAllText(configFile, clearText);\n    }\n\n    private static byte[] EncryptString(string clearText, byte[] key, byte[] iv)\n    {\n        using (Aes aes = Aes.Create())\n        {\n            aes.Key = key;\n            aes.IV = iv;\n            ICryptoTransform encryptor = aes.CreateEncryptor(aes.Key, aes.IV);\n            using (MemoryStream ms = new MemoryStream())\n            {\n                using (CryptoStream cs = new CryptoStream(ms, encryptor, CryptoStreamMode.Write))\n                {\n                    using (StreamWriter sw = new StreamWriter(cs))\n                    {\n                        sw.Write(clearText);\n                    }\n                    return ms.ToArray();\n                }\n            }\n        }\n    }\n\n    private static string DecryptString(byte[] encryptedBytes, byte[] key, byte[] iv)\n    {\n        using (Aes aes = Aes.Create())\n        {\n            aes.Key = key;\n            aes.IV = iv;\n            ICryptoTransform decryptor = aes.CreateDecryptor(aes.Key, aes.IV);\n            using (MemoryStream ms = new MemoryStream(encryptedBytes))\n            {\n                using (CryptoStream cs = new CryptoStream(ms, decryptor, CryptoStreamMode.Read))\n                {\n                    using (StreamReader sr = new StreamReader(cs))\n                    {\n                        return sr.ReadToEnd();\n                    }\n                }\n            }\n        }\n    }\n}