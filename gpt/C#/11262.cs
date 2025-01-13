using System;\nusing System.Security.Cryptography;\nusing System.Text;\n\npublic class KeyGenerator\n{\n    public static void GenerateKeys(out string publicKey, out string privateKey)\n    {\n        using (RSACryptoServiceProvider rsa = new RSACryptoServiceProvider(2048))\n        {\n            publicKey = Convert.ToBase64String(rsa.ExportCspBlob(false));\n            privateKey = Convert.ToBase64String(rsa.ExportCspBlob(true));\n        }\n    }\n}