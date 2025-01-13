using System;\nusing System.IO;\nusing System.Threading;\n\nclass Program\n{\n    private static readonly string logFilePath = "log.txt";\n    private static readonly Mutex mutex = new Mutex(false, "Global\\LogFileMutex");\n\n    static void Main()\n    {\n        LogMessage("This is a log message");\n    }\n\n    static void LogMessage(string message)\n    {\n        try\n        {\n            mutex.WaitOne();\n\n            using (StreamWriter writer = new StreamWriter(logFilePath, true))\n            {\n                writer.WriteLine($"{DateTime.Now}: {message}");\n            }\n        }\n        catch (Exception ex)\n        {\n            Console.WriteLine($"An error occurred: {ex.Message}");\n        }\n        finally\n        {\n            mutex.ReleaseMutex();\n        }\n    }\n}