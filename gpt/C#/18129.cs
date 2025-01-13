class Program\n{\n    static void Main()\n    {\n        string publicKey = "YOUR_RSA_PUBLIC_KEY_BASE64";\n        string privateKey = "YOUR_RSA_PRIVATE_KEY_BASE64";\n\n        RSAFileEncryption.EncryptFile("path/to/input/file.txt", "path/to/output/encryptedfile.enc", publicKey);\n        RSAFileDecryption.DecryptFile("path/to/output/encryptedfile.enc", "path/to/decrypted/file.txt", privateKey);\n    }\n}