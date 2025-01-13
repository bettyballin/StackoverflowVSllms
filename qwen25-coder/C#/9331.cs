using System;\nusing System.IO;\nusing System.Security.Cryptography;\n\npublic class FileEncryptor\n{\n    public static void EncryptFile(string inputFile, string outputFile, string publicKey)\n    {\n        // Generate a new symmetric key and initialization vector.\n        using (Aes aes = Aes.Create())\n        {\n            aes.GenerateKey();\n            aes.GenerateIV();\n\n            // Encrypt the file data with the symmetric AES algorithm.\n            byte[] encryptedFileBytes;\n            using (MemoryStream msOutput = new MemoryStream())\n            {\n                using (CryptoStream csEncrypt = new CryptoStream(msOutput, aes.CreateEncryptor(), CryptoStreamMode.Write))\n                {\n                    File.OpenRead(inputFile).CopyTo(csEncrypt);\n                    csEncrypt.FlushFinalBlock();\n                    encryptedFileBytes = msOutput.ToArray();\n                }\n            }\n\n            // Encrypt the symmetric key with RSA.\n            using (RSACryptoServiceProvider rsa = new RSACryptoServiceProvider())\n            {\n                byte[] keyValue = Convert.FromBase64String(publicKey);\n                rsa.ImportCspBlob(keyValue);\n\n                byte[] encryptedKey = rsa.Encrypt(aes.Key, true /*useOAEP: OAEP is better than PKCS#1*/);\n\n                // Write the encrypted symmetric key and IV to the output file.\n                using (FileStream fsOut = new FileStream(outputFile, FileMode.Create))\n                {\n                    fsOut.Write(BitConverter.GetBytes(encryptedKey.Length), 0, sizeof(int));\n                    fsOut.Write(encryptedKey, 0, encryptedKey.Length);\n                    fsOut.Write(BitConverter.GetBytes(aes.IV.Length), 0, sizeof(int));\n                    fsOut.Write(aes.IV, 0, aes.IV.Length);\n\n                    // Write the encrypted file data.\n                    fsOut.Write(encryptedFileBytes, 0, encryptedFileBytes.Length);\n                }\n            }\n        }\n    }\n\n    public static void DecryptFile(string inputFile, string outputFile, string privateKey)\n    {\n        using (FileStream fsIn = new FileStream(inputFile, FileMode.Open))\n        {\n            byte[] blobLengthBytes = new byte[sizeof(int)];\n            fsIn.Read(blobLengthBytes, 0, sizeof(int));\n            int encryptedKeyLength = BitConverter.ToInt32(blobLengthBytes, 0);\n\n            byte[] encryptedKey = new byte[encryptedKeyLength];\n            fsIn.Read(encryptedKey, 0, encryptedKeyLength);\n\n            fsIn.Read(blobLengthBytes, 0, sizeof(int));\n            int ivLength = BitConverter.ToInt32(blobLengthBytes, 0);\n\n            byte[] iv = new byte[ivLength];\n            fsIn.Read(iv, 0, ivLength);\n\n            using (RSACryptoServiceProvider rsa = new RSACryptoServiceProvider())\n            {\n                byte[] keyValue = Convert.FromBase64String(privateKey);\n                rsa.ImportCspBlob(keyValue);\n\n                byte[] key = rsa.Decrypt(encryptedKey, true /*useOAEP: OAEP is better than PKCS#1*/);\n\n                using (Aes aes = Aes.Create())\n                {\n                    aes.Key = key;\n                    aes.IV = iv;\n\n                    ICryptoTransform decryptor = aes.CreateDecryptor(aes.Key, aes.IV);\n                    using (FileStream fsOutput = new FileStream(outputFile, FileMode.Create))\n                    {\n                        using (CryptoStream csDecrypt = new CryptoStream(fsOutput, decryptor, CryptoStreamMode.Write))\n                        {\n                            fsIn.CopyTo(csDecrypt);\n                        }\n                    }\n                }\n            }\n        }\n    }\n\n    public static void Main()\n    {\n        string publicKey = "Your Base64 Public Key Here";\n        string privateKey = "Your Base64 Private Key Here";\n\n        try\n        {\n            EncryptFile("example.txt", "encrypted.dat", publicKey);\n            DecryptFile("encrypted.dat", "decrypted.txt", privateKey);\n        }\n        catch (Exception ex)\n        {\n            Console.WriteLine($"Error: {ex.Message}");\n        }\n    }\n}