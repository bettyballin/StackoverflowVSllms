public static class MyUtility\n{\n    private static readonly byte[] MyKey = ...; // Your key here\n    private static readonly byte[] MyIV = ...;  // Your initialization vector here\n\n    [ThreadStatic]\n    private static ICryptoTransform _encryptorTransform;\n\n    [ThreadStatic]\n    private static ICryptoTransform _decryptorTransform;\n\n    private static ICryptoTransform EncryptorTransform\n    {\n        get\n        {\n            if (_encryptorTransform == null)\n            {\n                _encryptorTransform = CreateEncryptor();\n            }\n            return _encryptorTransform;\n        }\n    }\n\n    private static ICryptoTransform DecryptorTransform\n    {\n        get\n        {\n            if (_decryptorTransform == null)\n            {\n                _decryptorTransform = CreateDecryptor();\n            }\n            return _decryptorTransform;\n        }\n    }\n\n    private static ICryptoTransform CreateEncryptor()\n    {\n        using (RijndaelManaged rm = new RijndaelManaged())\n        {\n            return rm.CreateEncryptor(MyKey, MyIV);\n        }\n    }\n\n    private static ICryptoTransform CreateDecryptor()\n    {\n        using (RijndaelManaged rm = new RijndaelManaged())\n        {\n            return rm.CreateDecryptor(MyKey, MyIV);\n        }\n    }\n\n    public static byte[] Encrypt(byte[] data)\n    {\n        // Use EncryptorTransform for encryption\n        return EncryptorTransform.TransformFinalBlock(data, 0, data.Length);\n    }\n\n    public static byte[] Decrypt(byte[] data)\n    {\n        // Use DecryptorTransform for decryption\n        return DecryptorTransform.TransformFinalBlock(data, 0, data.Length);\n    }\n}