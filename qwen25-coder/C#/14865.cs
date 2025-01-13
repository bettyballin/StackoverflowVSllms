using System;\nusing System.IO;\nusing System.Security.Cryptography;\n\npublic class LicenseEncryptor\n{\n    private const string Key = "1234567890abcdef"; // 16 bytes key\n    private const string IV = "abcdef9876543210";  // 16 bytes IV\n    \n    public static void EncryptFile(string inputFile, string outputFile)\n    {\n        using (Aes aesAlg = Aes.Create())\n        {\n            aesAlg.Key = Encoding.UTF8.GetBytes(Key);\n            aesAlg.IV = Encoding.UTF8.GetBytes(IV);\n\n            ICryptoTransform encryptor = aesAlg.CreateEncryptor(aesAlg.Key, aesAlg.IV);\n\n            using (FileStream fsOutput = new FileStream(outputFile, FileMode.Create))\n            using (CryptoStream csEncrypt = new CryptoStream(fsOutput, encryptor, CryptoStreamMode.Write))\n            using (FileStream fsInput = new FileStream(inputFile, FileMode.Open))\n            {\n                fsInput.CopyTo(csEncrypt);\n            }\n        }\n    }\n\n    public static void DecryptFile(string inputFile, string outputFile)\n    {\n        using (Aes aesAlg = Aes.Create())\n        {\n            aesAlg.Key = Encoding.UTF8.GetBytes(Key);\n            aesAlg.IV = Encoding.UTF8.GetBytes(IV);\n\n            ICryptoTransform decryptor = aesAlg.CreateDecryptor(aesAlg.Key, aesAlg.IV);\n\n            using (FileStream fsInput = new FileStream(inputFile, FileMode.Open))\n            using (CryptoStream csDecrypt = new CryptoStream(fsInput, decryptor, CryptoStreamMode.Read))\n            using (FileStream fsOutput = new FileStream(outputFile, FileMode.Create))\n            {\n                csDecrypt.CopyTo(fsOutput);\n            }\n        }\n    }\n}