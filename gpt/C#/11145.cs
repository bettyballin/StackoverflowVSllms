using System;\nusing System.IO;\nusing System.Security.Cryptography;\nusing System.Text;\n\nclass Program\n{\n    private static readonly string key = "hello world";\n\n    public static void Main()\n    {\n        string xmlContent = @"<root>\n                                <lic>\n                                    <number>19834209</number>\n                                    <expiry>02/02/2002</expiry>\n                                </lic>\n                              </root>";\n\n        string encryptedFilePath = "encrypted.xml";\n        string decryptedFilePath = "decrypted.xml";\n\n        EncryptXml(xmlContent, encryptedFilePath, key);\n        DecryptXml(encryptedFilePath, decryptedFilePath, key);\n    }\n\n    public static void EncryptXml(string xmlContent, string outputPath, string key)\n    {\n        byte[] keyBytes = Encoding.UTF8.GetBytes(key);\n        using (Aes aes = Aes.Create())\n        {\n            aes.Key = SHA256.Create().ComputeHash(keyBytes);\n            aes.IV = new byte[aes.BlockSize / 8]; // Initialize IV with zeros\n\n            using (FileStream fsCrypt = new FileStream(outputPath, FileMode.Create))\n            {\n                fsCrypt.Write(aes.IV, 0, aes.IV.Length);\n\n                using (CryptoStream cs = new CryptoStream(fsCrypt, aes.CreateEncryptor(), CryptoStreamMode.Write))\n                using (StreamWriter sw = new StreamWriter(cs))\n                {\n                    sw.Write(xmlContent);\n                }\n            }\n        }\n    }\n\n    public static void DecryptXml(string inputPath, string outputPath, string key)\n    {\n        byte[] keyBytes = Encoding.UTF8.GetBytes(key);\n        using (Aes aes = Aes.Create())\n        {\n            aes.Key = SHA256.Create().ComputeHash(keyBytes);\n\n            using (FileStream fsCrypt = new FileStream(inputPath, FileMode.Open))\n            {\n                byte[] iv = new byte[aes.BlockSize / 8];\n                fsCrypt.Read(iv, 0, iv.Length);\n                aes.IV = iv;\n\n                using (CryptoStream cs = new CryptoStream(fsCrypt, aes.CreateDecryptor(), CryptoStreamMode.Read))\n                using (StreamReader sr = new StreamReader(cs))\n                {\n                    string decryptedContent = sr.ReadToEnd();\n                    File.WriteAllText(outputPath, decryptedContent);\n                }\n            }\n        }\n    }\n}