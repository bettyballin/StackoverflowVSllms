using System;\nusing System.IO;\nusing System.Text;\nusing System.Security.Cryptography;\n\npublic class AesExample\n{\n    public static void Main()\n    {\n        string original = "Here is some data to encrypt!";\n\n        using (Aes aesAlg = Aes.Create())\n        {\n            aesAlg.Key = new byte[16] { 0x2b, 0x7e, 0x15, 0x16, 0x28, 0xae, 0xd2, 0xa6, 0xab, 0xf7, 0x15, 0x88, 0x09, 0xcf, 0x4f, 0x3c };\n            aesAlg.IV = new byte[16] { 0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09, 0x0a, 0x0b, 0x0c, 0x0d, 0x0e, 0x0f };\n\n            ICryptoTransform encryptor = aesAlg.CreateEncryptor(aesAlg.Key, aesAlg.IV);\n\n            using (MemoryStream msEncrypt = new MemoryStream())\n            {\n                using (CryptoStream csEncrypt = new CryptoStream(msEncrypt, encryptor, CryptoStreamMode.Write))\n                {\n                    using (StreamWriter swEncrypt = new StreamWriter(csEncrypt))\n                    {\n                        swEncrypt.Write(original);\n                    }\n                    byte[] encrypted = msEncrypt.ToArray();\n                    Console.WriteLine("Encrypted data: " + Convert.ToBase64String(encrypted));\n                }\n            }\n        }\n    }\n}