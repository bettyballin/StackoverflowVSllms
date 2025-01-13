public static void RecordToFile(string filename, Log log)\n{\n    try\n    {\n        string filePath = Path.Combine(Constants.APP_PATH, filename);\n\n        using (TextWriter textWriter = new StreamWriter(filePath, true))\n        {\n            textWriter.WriteLine(log.ToString());\n        }\n    }\n    catch (Exception ex)\n    {\n        EventLog.WriteEntry("MyService", $"Failed to write log to file: {ex.Message}", EventLogEntryType.Error);\n    }\n}