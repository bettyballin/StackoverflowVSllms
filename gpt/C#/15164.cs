using System;\nusing System.IO;\nusing System.Linq;\n\nclass Program\n{\n    static void Main()\n    {\n        string directoryPath = @"c:\mydir";\n        string[] textFiles = Directory.GetFiles(directoryPath, "*.txt");\n        \n        // Filter out non-existent files\n        string[] validTextFiles = textFiles.Where(file => File.Exists(file)).ToArray();\n\n        // Output valid files\n        foreach (string file in validTextFiles)\n        {\n            Console.WriteLine(file);\n        }\n    }\n}