using System;\nusing System.IO;\nusing System.Security.Cryptography;\n\npublic class FileComparer\n{\n    public static string ComputeSHA256(string filePath)\n    {\n        using (FileStream stream = File.OpenRead(filePath))\n        {\n            SHA256 sha256 = SHA256.Create();\n            byte[] hash = sha256.ComputeHash(stream);\n            return BitConverter.ToString(hash).Replace("-", "").ToLowerInvariant();\n        }\n    }\n\n    public static bool AreFilesIdentical(string filePath1, string filePath2)\n    {\n        string hash1 = ComputeSHA256(filePath1);\n        string hash2 = ComputeSHA256(filePath2);\n        return hash1 == hash2;\n    }\n\n    public static void Main()\n    {\n        string filePathA = "path/to/your/fileA";\n        string filePathB = "path/to/your/fileB";\n\n        bool areIdentical = AreFilesIdentical(filePathA, filePathB);\n        Console.WriteLine("The files are " + (areIdentical ? "identical" : "different"));\n    }\n}