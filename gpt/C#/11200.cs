using System;\nusing System.Security.Cryptography;\n\npublic class MachineKeyGenerator\n{\n    public static void Main()\n    {\n        Console.WriteLine("Validation Key: " + GenerateKey(64));\n        Console.WriteLine("Decryption Key: " + GenerateKey(32));\n    }\n\n    private static string GenerateKey(int byteLength)\n    {\n        byte[] key = new byte[byteLength];\n        using (RNGCryptoServiceProvider rng = new RNGCryptoServiceProvider())\n        {\n            rng.GetBytes(key);\n        }\n        return BitConverter.ToString(key).Replace("-", "");\n    }\n}