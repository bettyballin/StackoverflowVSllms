using System;\nusing System.IO;\nusing System.Security.Cryptography;\nusing System.Text;\n\npublic class FileEncryption\n{\n    private static readonly byte[] key = Encoding.UTF8.GetBytes("your-256-bit-key");\n    private static readonly byte[] iv = Encoding.UTF8.GetBytes("your-128-bit-iv");\n\n    public static void EncryptFile(string inputFile, string outputFile)\n    {\n        using (Aes aes = Aes.Create())\n        {\n            aes.Key = key;\n            aes.IV = iv;\n            ICryptoTransform encryptor = aes.CreateEncryptor(aes.Key, aes.IV);\n\n            using (FileStream fsOutput = new FileStream(outputFile, FileMode.Create))\n            using (CryptoStream cs = new CryptoStream(fsOutput, encryptor, CryptoStreamMode.Write))\n            using (FileStream fsInput = new FileStream(inputFile, FileMode.Open))\n            {\n                byte[] buffer = new byte[1024];\n                int read;\n                while ((read = fsInput.Read(buffer, 0, buffer.Length)) > 0)\n                {\n                    cs.Write(buffer, 0, read);\n                }\n            }\n        }\n    }\n\n    public static void DecryptFile(string inputFile, string outputFile)\n    {\n        using (Aes aes = Aes.Create())\n        {\n            aes.Key = key;\n            aes.IV = iv;\n            ICryptoTransform decryptor = aes.CreateDecryptor(aes.Key, aes.IV);\n\n            using (FileStream fsInput = new FileStream(inputFile, FileMode.Open))\n            using (CryptoStream cs = new CryptoStream(fsInput, decryptor, CryptoStreamMode.Read))\n            using (FileStream fsOutput = new FileStream(outputFile, FileMode.Create))\n            {\n                byte[] buffer = new byte[1024];\n                int read;\n                while ((read = cs.Read(buffer, 0, buffer.Length)) > 0)\n                {\n                    fsOutput.Write(buffer, 0, read);\n                }\n            }\n        }\n    }\n}