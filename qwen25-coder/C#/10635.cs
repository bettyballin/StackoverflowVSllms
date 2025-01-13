using System;\nusing System.IO;\n\npublic static class ErrorLogger\n{\n    public static void LogException(Exception ex)\n    {\n        try\n        {\n            string path = Path.Combine(Environment.GetFolderPath(Environment.SpecialFolder.LocalApplicationData), "YourAppName", "logs");\n            Directory.CreateDirectory(path);\n            using (StreamWriter writer = new StreamWriter(Path.Combine(path, "errorLog.txt"), true))\n            {\n                writer.WriteLine($"{DateTime.Now}: {ex.Message}\nStack Trace:\n{ex.StackTrace}\n-------------------\n");\n            }\n        }\n        catch (Exception)\n        {\n            // Fallback error handling or notification\n        }\n    }\n}