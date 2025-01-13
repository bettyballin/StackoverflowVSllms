using System.Security.Cryptography;\n   public static string EncryptString(string clearText)\n   {\n       byte[] iv = new byte[16];\n       byte[] array;\n\n       using (Aes aes = Aes.Create())\n       {\n           aes.Key = Encoding.UTF8.GetBytes("YourSecretKeyHere!");\n           aes.IV = iv;\n\n           ICryptoTransform encryptor = aes.CreateEncryptor(aes.Key, aes.IV);\n\n           using (MemoryStream memoryStream = new MemoryStream())\n           {\n               using (CryptoStream cryptoStream = new CryptoStream(memoryStream, encryptor, CryptoStreamMode.Write))\n               {\n                   using (StreamWriter streamWriter = new StreamWriter(cryptoStream))\n                   {\n                       streamWriter.Write(clearText);\n                   }\n\n                   array = memoryStream.ToArray();\n               }\n           }\n       }\n\n       return Convert.ToBase64String(array);\n   }