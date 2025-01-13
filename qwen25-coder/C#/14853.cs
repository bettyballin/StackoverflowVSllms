using System;\nusing System.IO;\nusing System.Text;\n\npublic class ConsoleLogger\n{\n    private StringBuilder _outputBuffer = new StringBuilder();\n\n    public void Write(string s)\n    {\n        _outputBuffer.Append(s);\n        Console.Write(s);\n    }\n\n    public void WriteLine()\n    {\n        _outputBuffer.AppendLine();\n        Console.WriteLine();\n    }\n\n    public void WriteLine(string s)\n    {\n        _outputBuffer.AppendLine(s);\n        Console.WriteLine(s);\n    }\n\n    public void LogToFileAndConsole(string filePath)\n    {\n        File.WriteAllText(filePath, _outputBuffer.ToString());\n    }\n}\n\nclass Program\n{\n    static void Main()\n    {\n        var logger = new ConsoleLogger();\n\n        // Example usage of the logger\n        logger.Write("Starting the application...");\n        logger.WriteLine();\n        logger.WriteLine("Performing some operations...");\n\n        // Simulate some operations\n        for (int i = 0; i < 5; i++)\n        {\n            logger.Write($"Operation {i + 1} completed.");\n            logger.WriteLine();\n        }\n\n        // Log everything to a file at the end of execution\n        logger.LogToFileAndConsole("output.log");\n    }\n}