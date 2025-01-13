using System;\nusing System.Security.Cryptography;\nusing System.Text;\n\npublic class PrivateKeyProtector\n{\n    public static byte[] EncryptPrivateKey(byte[] privateKey, string password)\n    {\n        // Derive a key from the password using PBKDF2\n        var salt = new byte[16];\n        new RNGCryptoServiceProvider().GetBytes(salt);\n        var key = PBKDF2(password, salt, 1000, 32);\n\n        // Encrypt the private key using AES\n        using (var aes = Aes.Create())\n        {\n            aes.Key = key;\n            aes.IV = new byte[16];\n            using (var encryptor = aes.CreateEncryptor())\n            {\n                return encryptor.TransformFinalBlock(privateKey, 0, privateKey.Length);\n            }\n        }\n    }\n\n    public static byte[] DecryptPrivateKey(byte[] encryptedPrivateKey, string password)\n    {\n        // Derive the key from the password using PBKDF2\n        var salt = new byte[16];\n        new RNGCryptoServiceProvider().GetBytes(salt);\n        var key = PBKDF2(password, salt, 1000, 32);\n\n        // Decrypt the private key using AES\n        using (var aes = Aes.Create())\n        {\n            aes.Key = key;\n            aes.IV = new byte[16];\n            using (var decryptor = aes.CreateDecryptor())\n            {\n                return decryptor.TransformFinalBlock(encryptedPrivateKey, 0, encryptedPrivateKey.Length);\n            }\n        }\n    }\n\n    private static byte[] PBKDF2(string password, byte[] salt, int iterations, int outputBytes)\n    {\n        using (var pbkdf2 = new Rfc2898DeriveBytes(password, salt, iterations))\n        {\n            return pbkdf2.GetBytes(outputBytes);\n        }\n    }\n}