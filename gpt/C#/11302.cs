using System;\nusing System.IO;\n\nclass Program\n{\n    static void Main(string[] args)\n    {\n        WriteToConsole(1, "This is a message for console 1.");\n        WriteToConsole(2, "This is a message for console 2.");\n        WriteToConsole(1, "Another message for console 1.");\n    }\n\n    static void WriteToConsole(int consoleNumber, string message)\n    {\n        string fileName = $"Console{consoleNumber}.txt";\n        using (StreamWriter writer = new StreamWriter(fileName, true))\n        {\n            writer.WriteLine(message);\n        }\n    }\n}