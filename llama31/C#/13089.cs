using System;\nusing System.Security.Cryptography;\nusing System.Text;\n\npublic class PkiLibrary\n{\n    public static string Encrypt(string data, string publicKey)\n    {\n        using (var rsa = new RSACryptoServiceProvider())\n        {\n            rsa.FromXmlString(publicKey);\n            var dataBytes = Encoding.UTF8.GetBytes(data);\n            var encryptedBytes = rsa.Encrypt(dataBytes, false);\n            return Convert.ToBase64String(encryptedBytes);\n        }\n    }\n\n    public static string Decrypt(string encryptedData, string privateKey)\n    {\n        using (var rsa = new RSACryptoServiceProvider())\n        {\n            rsa.FromXmlString(privateKey);\n            var encryptedBytes = Convert.FromBase64String(encryptedData);\n            var decryptedBytes = rsa.Decrypt(encryptedBytes, false);\n            return Encoding.UTF8.GetString(decryptedBytes);\n        }\n    }\n}