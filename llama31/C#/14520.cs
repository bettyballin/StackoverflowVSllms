byte[] plainBytes = Encoding.UTF8.GetBytes("Hello, World!");\nbyte[] key = new byte[32]; // 256-bit key\nbyte[] iv = new byte[16]; // 128-bit IV\n\n// Generate random key and IV\nusing (RNGCryptoServiceProvider rng = new RNGCryptoServiceProvider())\n{\n    rng.GetBytes(key);\n    rng.GetBytes(iv);\n}\n\nbyte[] encryptedBytes = ByteArrayEncryption.Encrypt(plainBytes, key, iv);