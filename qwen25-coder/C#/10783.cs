using System;\nusing System.IO;\nusing System.Text;\n\nclass Program\n{\n    static void Main()\n    {\n        string inputFilePath = "path/to/your/file.txt";\n        string outputFilePath = "path/to/your/outputfile.txt";\n\n        using (var reader = new StreamReader(inputFilePath, Encoding.Default)) // ANSI is often Default encoding on Windows\n        using (var writer = new StreamWriter(outputFilePath, false, Encoding.ASCII))\n        {\n            string line;\n            while ((line = reader.ReadLine()) != null)\n            {\n                // Convert the current line to ASCII bytes and back to a string.\n                byte[] asciiBytes = Encoding.Convert(Encoding.Default, Encoding.ASCII, Encoding.Default.GetBytes(line));\n                string asciiLine = Encoding.ASCII.GetString(asciiBytes);\n\n                writer.WriteLine(asciiLine);\n            }\n        }\n    }\n}