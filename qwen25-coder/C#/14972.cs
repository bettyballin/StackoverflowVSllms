using ArmorLib.Crypto;\n\npublic class EncryptorDecryptor\n{\n    private readonly IArmorCrypto crypto;\n    \n    public EncryptorDecryptor(IArmorCrypto crypto)\n    {\n        this.crypto = crypto;\n    }\n\n    public byte[] Encrypt(byte[] data, string key)\n    {\n        return crypto.Aes256Encrypt(data, key);\n    }\n\n    public byte[] Decrypt(byte[] encryptedData, string key)\n    {\n        return crypto.Aes256Decrypt(encryptedData, key);\n    }\n}