using System;\nusing System.IO;\n\nclass Program\n{\n    static void Main()\n    {\n        string filePath = "path_to_your_file.txt";\n\n        // Ensure the file exists\n        if (File.Exists(filePath))\n        {\n            // Read all lines from the file\n            string[] lines = File.ReadAllLines(filePath);\n\n            // Process each line\n            foreach (var line in lines)\n            {\n                Console.WriteLine(line);\n                // Further processing can be done here\n            }\n        }\n        else\n        {\n            Console.WriteLine("File not found.");\n        }\n    }\n}