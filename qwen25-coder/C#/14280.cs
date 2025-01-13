public static class MyUtility\n{\n    private static byte[] MyKey = ...; // Your key initialization\n    private static byte[] MyIV = ...;  // Your IV initialization\n\n    public static byte[] Encrypt(byte[] data)\n    {\n        using (RijndaelManaged rm = new RijndaelManaged())\n        {\n            ICryptoTransform encryptor = rm.CreateEncryptor(MyKey, MyIV);\n            return Transform(encryptor, data);\n        }\n    }\n\n    public static byte[] Decrypt(byte[] data)\n    {\n        using (RijndaelManaged rm = new RijndaelManaged())\n        {\n            ICryptoTransform decryptor = rm.CreateDecryptor(MyKey, MyIV);\n            return Transform(decryptor, data);\n        }\n    }\n\n    private static byte[] Transform(ICryptoTransform transform, byte[] data)\n    {\n        using (MemoryStream ms = new MemoryStream())\n        {\n            using (CryptoStream cs = new CryptoStream(ms, transform, CryptoStreamMode.Write))\n            {\n                cs.Write(data, 0, data.Length);\n            }\n            return ms.ToArray();\n        }\n    }\n}