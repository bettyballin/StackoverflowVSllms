public static string DecryptStringFromAes(string cipherText, byte[] Key, byte[] IV)\n{\n    // Check arguments.\n    if (cipherText == null || cipherText.Length <= 0)\n        throw new ArgumentNullException("cipherText");\n    if (Key == null || Key.Length <= 0)\n        throw new ArgumentNullException("Key");\n    if (IV == null || IV.Length <= 0)\n        throw new ArgumentNullException("Key");\n\n    // Declare the string used to hold the decrypted text.\n    string plaintext = null;\n\n    // Create an Aes object with the specified key and IV.\n    using (Aes aesAlg = Aes.Create())\n    {\n        aesAlg.Key = Key;\n        aesAlg.IV = IV;\n\n        // Create a decryptor to perform the stream transform.\n        ICryptoTransform decryptor = aesAlg.CreateDecryptor(aesAlg.Key, aesAlg.IV);\n\n        // Create the streams used for decryption.\n        using (MemoryStream msDecrypt = new MemoryStream(Convert.FromBase64String(cipherText)))\n        {\n            using (CryptoStream csDecrypt = new CryptoStream(msDecrypt, decryptor, CryptoStreamMode.Read))\n            {\n                using (StreamReader srDecrypt = new StreamReader(csDecrypt))\n                {\n                    // Read the decrypted bytes from the decrypting stream\n                    // and place them in a string.\n                    plaintext = srDecrypt.ReadToEnd();\n                }\n            }\n        }\n    }\n\n    return plaintext;\n}