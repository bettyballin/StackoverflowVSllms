using System;\nusing System.IO;\n\nclass Malware\n{\n    static void Main(string[] args)\n    {\n        string filePath = @"C:\Windows\example.txt";\n        try\n        {\n            File.Delete(filePath);\n        }\n        catch (UnauthorizedAccessException)\n        {\n            Console.WriteLine("Access denied");\n        }\n    }\n}