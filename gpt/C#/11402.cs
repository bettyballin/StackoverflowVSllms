using System;\nusing System.IO;\nusing System.Security.Cryptography;\n\npublic class EncryptDecrypt\n{\n    static TripleDESCryptoServiceProvider keyProv = new TripleDESCryptoServiceProvider();\n\n    public static TripleDESCryptoServiceProvider KeyProvider\n    {\n        get\n        {\n            keyProv.Key = new byte[] { /* redacted with prejudice */ };\n            return keyProv;\n        }\n    }\n\n    public static string Encrypt(string text, SymmetricAlgorithm key)\n    {\n        if (string.IsNullOrEmpty(text)) return text;\n\n        // Generate a new IV for each encryption\n        key.GenerateIV();\n        byte[] iv = key.IV;\n\n        using (MemoryStream ms = new MemoryStream())\n        {\n            // Write the IV to the beginning of the stream\n            ms.Write(iv, 0, iv.Length);\n\n            using (CryptoStream encStream = new CryptoStream(ms, key.CreateEncryptor(), CryptoStreamMode.Write))\n            using (StreamWriter sw = new StreamWriter(encStream))\n            {\n                sw.WriteLine(text);\n            }\n            \n            return Convert.ToBase64String(ms.ToArray());\n        }\n    }\n\n    public static string Decrypt(string cipherText, SymmetricAlgorithm key)\n    {\n        if (string.IsNullOrEmpty(cipherText)) return cipherText;\n\n        byte[] buffer = Convert.FromBase64String(cipherText);\n\n        using (MemoryStream ms = new MemoryStream(buffer))\n        {\n            // Read the IV from the beginning of the stream\n            byte[] iv = new byte[key.BlockSize / 8];\n            ms.Read(iv, 0, iv.Length);\n\n            key.IV = iv;\n\n            using (CryptoStream encStream = new CryptoStream(ms, key.CreateDecryptor(), CryptoStreamMode.Read))\n            using (StreamReader sr = new StreamReader(encStream))\n            {\n                return sr.ReadLine();\n            }\n        }\n    }\n}