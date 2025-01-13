using System;\nusing System.IO;\n\nclass Program\n{\n    static void Main()\n    {\n        string tempPath = Path.GetTempPath();\n        string fileName;\n\n        do\n        {\n            fileName = Path.Combine(tempPath, Path.GetRandomFileName());\n            fileName = Path.ChangeExtension(fileName, ".csv");\n        }\n        while (File.Exists(fileName));\n\n        // Use the file (e.g., create it)\n        using (var stream = File.Create(fileName))\n        {\n            // File creation logic here\n        }\n\n        Console.WriteLine("Temporary file created: " + fileName);\n    }\n}