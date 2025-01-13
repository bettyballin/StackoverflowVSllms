using System;\nusing System.IO;\n\nclass Program\n{\n    static void Main()\n    {\n        string inputFilePath = "path/to/your/file.txt";\n        using (var fileStream = new FileStream(inputFilePath, FileMode.Open, FileAccess.Read))\n        using (var binaryReader = new BinaryReader(fileStream, Encoding.Default))\n        {\n            // You can read the bytes here\n            byte[] bytes = binaryReader.ReadBytes((int)fileStream.Length);\n            string ansiString = Encoding.Default.GetString(bytes);\n            \n            // Convert to ASCII as shown in the first example\n            byte[] asciiBytes = Encoding.Convert(Encoding.Default, Encoding.ASCII, Encoding.Default.GetBytes(ansiString));\n            string asciiString = Encoding.ASCII.GetString(asciiBytes);\n\n            Console.WriteLine(asciiString);\n        }\n    }\n}