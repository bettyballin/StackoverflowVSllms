using System;\nusing System.Security.Cryptography;\nusing System.Text;\n\npublic class EncryptionHelper\n{\n    public static string Encrypt(string plainText, string key)\n    {\n        using (Aes aesAlg = Aes.Create())\n        {\n            aesAlg.Key = Encoding.UTF8.GetBytes(key);\n            aesAlg.GenerateIV();\n            byte[] iv = aesAlg.IV;\n            byte[] encrypted;\n\n            using (var encryptor = aesAlg.CreateEncryptor(aesAlg.Key, aesAlg.IV))\n            {\n                using (var msEncrypt = new System.IO.MemoryStream())\n                {\n                    using (var csEncrypt = new CryptoStream(msEncrypt, encryptor, CryptoStreamMode.Write))\n                    {\n                        using (var swEncrypt = new System.IO.StreamWriter(csEncrypt))\n                        {\n                            swEncrypt.Write(plainText);\n                        }\n                        encrypted = msEncrypt.ToArray();\n                    }\n                }\n            }\n\n            byte[] result = new byte[iv.Length + encrypted.Length];\n            Buffer.BlockCopy(iv, 0, result, 0, iv.Length);\n            Buffer.BlockCopy(encrypted, 0, result, iv.Length, encrypted.Length);\n\n            return Convert.ToBase64String(result);\n        }\n    }\n}