using System;\nusing System.IO;\nusing System.Security.Cryptography;\nusing System.Text;\nusing System.Xml;\n\npublic class XmlEncryptorDecryptor\n{\n    private static readonly byte[] Key = Encoding.UTF8.GetBytes("hello world"); // NOT RECOMMENDED FOR PRODUCTION\n\n    public static void EncryptXmlFile(string inputFile, string outputFile)\n    {\n        try\n        {\n            XmlDocument xmlDoc = new XmlDocument();\n            xmlDoc.Load(inputFile);\n\n            XmlElement rootElement = xmlDoc.DocumentElement;\n\n            Aes aesAlg = Aes.Create();\n            aesAlg.Key = GenerateKey(Key);\n            aesAlg.GenerateIV();\n\n            ENC.Encrypt(xmlDoc, rootElement, aesAlg.IV);\n\n            using (var fs = new FileStream(outputFile, FileMode.Create))\n            {\n                xmlDoc.Save(fs);\n                Console.WriteLine("Encryption successful.");\n            }\n        }\n        catch (Exception ex)\n        {\n            Console.WriteLine($"Error: {ex.Message}");\n        }\n    }\n\n    public static void DecryptXmlFile(string inputFile, string outputFile)\n    {\n        try\n        {\n            XmlDocument xmlDoc = new XmlDocument();\n            xmlDoc.Load(inputFile);\n\n            XmlElement rootElement = xmlDoc.DocumentElement;\n\n            Aes aesAlg = Aes.Create();\n            aesAlg.Key = GenerateKey(Key);\n            \n            var ivAttribute = rootElement.Attributes[ENC.EncryptionMethod.ElementName];\n            aesAlg.IV = Convert.FromBase64String(ivAttribute.Value);\n\n            ENC.Decrypt(xmlDoc, rootElement);\n            \n            using (var fs = new FileStream(outputFile, FileMode.Create))\n            {\n                xmlDoc.Save(fs);\n                Console.WriteLine("Decryption successful.");\n            }\n        }\n        catch (Exception ex)\n        {\n            Console.WriteLine($"Error: {ex.Message}");\n        }\n    }\n\n    private static byte[] GenerateKey(byte[] key)\n    {\n        // In a real-world scenario, securely derive the key using Key Derivation Functions such as PBKDF2\n        if (key.Length >= 16)\n        {\n            return key;\n        }\n        \n        var ret = new byte[16];\n        Buffer.BlockCopy(key, 0, ret, 0, Math.Min(16, key.Length));\n        return ret;\n    }\n\n    static void Main(string[] args)\n    {\n        string inputFile = "input.xml";\n        string encryptedFile = "encrypted.xml";\n        string decryptedFile = "decrypted.xml";\n\n        EncryptXmlFile(inputFile, encryptedFile);\n        DecryptXmlFile(encryptedFile, decryptedFile);\n    }\n}