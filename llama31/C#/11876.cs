using System;\nusing System.IO;\n\nclass Program\n{\n    static void Main()\n    {\n        string filePath = "input.txt";\n        string fileContent = File.ReadAllText(filePath);\n\n        Console.WriteLine(fileContent);\n    }\n}