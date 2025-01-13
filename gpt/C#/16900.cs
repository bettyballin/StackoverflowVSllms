using System;\nusing System.IO;\nusing System.Security.Cryptography;\n\npublic class HashGenerator\n{\n    public static string CalculateFileHash(string filePath)\n    {\n        using (var sha256 = SHA256.Create())\n        {\n            using (var stream = File.OpenRead(filePath))\n            {\n                var hash = sha256.ComputeHash(stream);\n                return BitConverter.ToString(hash).Replace("-", "").ToLowerInvariant();\n            }\n        }\n    }\n\n    public static void Main()\n    {\n        string filePath = "path/to/your/dllfile.dll";\n        string hash = CalculateFileHash(filePath);\n        Console.WriteLine($"Hash: {hash}");\n    }\n}