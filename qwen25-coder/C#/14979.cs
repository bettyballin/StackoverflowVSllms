using System;\nusing System.IO;\n\nclass Program\n{\n    static void Main()\n    {\n        string filePath = @"C:\path\to\your\file.txt";\n        \n        // Update the last write time to the current time\n        File.SetLastWriteTime(filePath, DateTime.Now);\n        \n        Console.WriteLine("File timestamp updated.");\n    }\n}