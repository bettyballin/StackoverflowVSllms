string encryptedPassword = "YourEncryptedPasswordHere";\nbyte[] key = Encoding.UTF8.GetBytes("YourKeyHere"); // Ensure your key is of the correct size (e.g., 16, 24, or 32 bytes for AES)\nbyte[] iv = Encoding.UTF8.GetBytes("YourIVHere"); // Ensure your IV is of the correct size (16 bytes for AES)\n\nstring decryptedPassword = AesEncryption.Decrypt(encryptedPassword, key, iv);\nConsole.WriteLine("Decrypted Password: " + decryptedPassword);