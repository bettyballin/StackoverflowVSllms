using System;\nusing System.IO;\n\nclass Program\n{\n    static void Main()\n    {\n        string fileName = GenerateRandomString(5) + ".txt";\n        string filePath = Path.Combine("C:\\", fileName);\n\n        // Create the file\n        File.WriteAllText(filePath, "This is a randomly named file.");\n\n        Console.WriteLine($"File created: {filePath}");\n    }\n\n    static string GenerateRandomString(int length)\n    {\n        const string chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";\n        Random random = new Random();\n        char[] stringChars = new char[length];\n\n        for (int i = 0; i < length; i++)\n        {\n            stringChars[i] = chars[random.Next(chars.Length)];\n        }\n\n        return new string(stringChars);\n    }\n}