using System.Security.Cryptography;\n\npublic class RSAKeyGenerator\n{\n    public static void GenerateRSAKeyPair(int keySize)\n    {\n        using (var rsa = new RSACryptoServiceProvider(keySize))\n        {\n            // Get the private key\n            var privateKey = rsa.ExportParameters(true);\n\n            // Get the public key\n            var publicKey = rsa.ExportParameters(false);\n\n            // Use the keys as needed...\n        }\n    }\n}