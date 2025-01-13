using System;\nusing System.Collections.Generic;\nusing System.Security.Cryptography;\n\nclass TripleDESEncryption\n{\n    private readonly TripleDESCryptoServiceProvider engine;\n\n    public TripleDESEncryption()\n    {\n        engine = new TripleDESCryptoServiceProvider();\n        engine.GenerateKey();\n        engine.GenerateIV();\n    }\n\n    public byte[] Encrypt(byte[] plain)\n    {\n        using (var encryptor = engine.CreateEncryptor(engine.Key, engine.IV))\n        {\n            return encryptor.TransformFinalBlock(plain, 0, plain.Length);\n        }\n    }\n\n    public byte[] Decrypt(byte[] encrypted)\n    {\n        using (var decryptor = engine.CreateDecryptor(engine.Key, engine.IV))\n        {\n            return decryptor.TransformFinalBlock(encrypted, 0, encrypted.Length);\n        }\n    }\n}\n\nclass Program\n{\n    static readonly int MAX_TEXT_LENGTH = 128;\n\n    static void Main(string[] args)\n    {\n        Console.WriteLine("{0,10}{1,10}{2,10}{3,10}", "Algo", "Input Size", "Encrypted Size", "Decrypted Size");\n\n        var tripleDES = new TripleDESEncryption();\n        var input = new List<byte>();\n\n        for (int i = 0; i <= MAX_TEXT_LENGTH; i++)\n        {\n            var plain = input.ToArray();\n            var encrypted = tripleDES.Encrypt(plain);\n            var decrypted = tripleDES.Decrypt(encrypted);\n\n            Console.WriteLine("{0,10}{1,10}{2,10}{3,10}", "Triple DES", input.Count, encrypted.Length, decrypted.Length);\n\n            input.Add(0x65); // Add a byte to the input\n        }\n\n        Console.ReadLine();\n    }\n}