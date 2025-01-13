using System;\nusing System.IO;\n\npublic class Program\n{\n    public static void Main()\n    {\n        string filePath = "path_to_your_file.txt";\n        int desiredLineNumber = 5;\n\n        using (StreamReader reader = new StreamReader(filePath))\n        {\n            int currentLineNumber = 0;\n            string line;\n\n            while ((line = reader.ReadLine()) != null)\n            {\n                currentLineNumber++;\n\n                if (currentLineNumber == desiredLineNumber)\n                {\n                    Console.WriteLine(line);\n                    break;\n                }\n            }\n        }\n    }\n}