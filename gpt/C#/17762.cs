using System;\nusing System.Security.Cryptography;\nusing System.Text;\n\nclass Program\n{\n    static void Main()\n    {\n        string originalKey = "MySuperSecretKey";\n\n        // Protect the key\n        byte[] protectedKey = Protect(Encoding.UTF8.GetBytes(originalKey));\n\n        // Unprotect the key\n        byte[] unprotectedKey = Unprotect(protectedKey);\n\n        Console.WriteLine($"Original Key: {originalKey}");\n        Console.WriteLine($"Unprotected Key: {Encoding.UTF8.GetString(unprotectedKey)}");\n    }\n\n    public static byte[] Protect(byte[] data)\n    {\n        return ProtectedData.Protect(data, null, DataProtectionScope.CurrentUser);\n    }\n\n    public static byte[] Unprotect(byte[] data)\n    {\n        return ProtectedData.Unprotect(data, null, DataProtectionScope.CurrentUser);\n    }\n}