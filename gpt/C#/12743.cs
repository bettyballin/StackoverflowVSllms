using System;\nusing System.Security.Cryptography;\nusing System.Text;\n\npublic class KeyManagement\n{\n    public static void StoreKey(string key, string containerName)\n    {\n        CspParameters cspParams = new CspParameters\n        {\n            KeyContainerName = containerName\n        };\n\n        using (RSACryptoServiceProvider rsa = new RSACryptoServiceProvider(cspParams))\n        {\n            rsa.PersistKeyInCsp = true;\n            byte[] keyBytes = Encoding.UTF8.GetBytes(key);\n            rsa.ImportCspBlob(keyBytes);\n        }\n    }\n\n    public static string RetrieveKey(string containerName)\n    {\n        CspParameters cspParams = new CspParameters\n        {\n            KeyContainerName = containerName\n        };\n\n        using (RSACryptoServiceProvider rsa = new RSACryptoServiceProvider(cspParams))\n        {\n            byte[] keyBytes = rsa.ExportCspBlob(true);\n            return Encoding.UTF8.GetString(keyBytes);\n        }\n    }\n}\n\npublic class Program\n{\n    public static void Main()\n    {\n        string privateKey = "your-private-key";\n        string containerName = "MyKeyContainer";\n\n        KeyManagement.StoreKey(privateKey, containerName);\n        string retrievedKey = KeyManagement.RetrieveKey(containerName);\n\n        Console.WriteLine($"Retrieved Key: {retrievedKey}");\n    }\n}