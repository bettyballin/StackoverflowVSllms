using System;\nusing System.IO;\nusing System.Security.Cryptography;\n\npublic class FileComparer\n{\n    public static bool AreFilesEqual(string path1, string path2)\n    {\n        using (var hashAlgorithm = SHA256.Create())\n        {\n            var hash1 = ComputeHash(hashAlgorithm, path1);\n            var hash2 = ComputeHash(hashAlgorithm, path2);\n\n            return StructuralComparisons.StructuralEqualityComparer.Equals(hash1, hash2);\n        }\n    }\n\n    private static byte[] ComputeHash(HashAlgorithm algorithm, string filePath)\n    {\n        using (var stream = new FileStream(filePath, FileMode.Open, FileAccess.Read, FileShare.Read))\n        {\n            return algorithm.ComputeHash(stream);\n        }\n    }\n\n    public static void Main()\n    {\n        string file1Path = "path/to/file1";\n        string file2Path = "path/to/file2";\n\n        bool areEqual = AreFilesEqual(file1Path, file2Path);\n        Console.WriteLine($"Are the files equal? {areEqual}");\n    }\n}