using System;\nusing System.Security.Cryptography;\n\npublic class StringObfuscator\n{\n    private static byte[] key = { 0x21, 0x34, 0x56, 0x78, 0x90, 0xAB, 0xCD, 0xEF };\n    public static string Obfuscate(string plainText)\n    {\n        using (var aesAlg = Aes.Create())\n        {\n            aesAlg.Key = key;\n            aesAlg.IV = new byte[aesAlg.BlockSize / 8];\n            var encryptor = aesAlg.CreateEncryptor(aesAlg.Key, aesAlg.IV);\n            return Convert.ToBase64String(PerformCryptography(plainText, encryptor));\n        }\n    }\n\n    public static string Unobfuscate(string cipherText)\n    {\n        using (var aesAlg = Aes.Create())\n        {\n            aesAlg.Key = key;\n            aesAlg.IV = new byte[aesAlg.BlockSize / 8];\n            var decryptor = aesAlg.CreateDecryptor(aesAlg.Key, aesAlg.IV);\n            return Encoding.UTF8.GetString(PerformCryptography(Convert.FromBase64String(cipherText), decryptor));\n        }\n    }\n\n    private static byte[] PerformCryptography(byte[] data, ICryptoTransform cryptoTransform)\n    {\n        using (var ms = new System.IO.MemoryStream())\n        using (var cs = new CryptoStream(ms, cryptoTransform, CryptoStreamMode.Write))\n        {\n            cs.Write(data, 0, data.Length);\n            cs.FlushFinalBlock();\n            return ms.ToArray();\n        }\n    }\n\n    private static byte[] PerformCryptography(string text, ICryptoTransform cryptoTransform)\n    {\n        var data = Encoding.UTF8.GetBytes(text);\n        using (var ms = new System.IO.MemoryStream())\n        using (var cs = new CryptoStream(ms, cryptoTransform, CryptoStreamMode.Write))\n        {\n            cs.Write(data, 0, data.Length);\n            cs.FlushFinalBlock();\n            return ms.ToArray();\n        }\n    }\n}