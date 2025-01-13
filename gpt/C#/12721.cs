private static byte[] DecryptData(byte[] data)\n{\n    using (Aes aes = Aes.Create())\n    {\n        aes.Key = Key;\n        aes.IV = IV;\n        using (MemoryStream ms = new MemoryStream())\n        {\n            using (CryptoStream cs = new CryptoStream(ms, aes.CreateDecryptor(), CryptoStreamMode.Write))\n            {\n                cs.Write(data, 0, data.Length);\n                cs.FlushFinalBlock();\n                return ms.ToArray();\n            }\n        }\n    }\n}