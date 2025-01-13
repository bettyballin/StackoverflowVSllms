using System;\nusing System.Collections.Generic;\nusing System.IO;\nusing System.Linq;\n\npublic class LogParser\n{\n    private List<LogEntry> logEntries = new List<LogEntry>();\n\n    public LogParser(string filePath)\n    {\n        ParseLogFile(filePath);\n    }\n\n    private void ParseLogFile(string filePath)\n    {\n        using (var reader = new StreamReader(filePath))\n        {\n            string line;\n            while ((line = reader.ReadLine()) != null)\n            {\n                // Assuming log entries are comma-separated\n                var parts = line.Split(',');\n                if (parts.Length >= 3)\n                {\n                    logEntries.Add(new LogEntry(parts[0], parts[1], parts[2]));\n                }\n            }\n        }\n    }\n\n    public IEnumerable<LogEntry> Entries => logEntries.AsEnumerable();\n}\n\npublic class LogEntry\n{\n    public string Date { get; set; }\n    public string Source { get; set; }\n    public string Message { get; set; }\n\n    public LogEntry(string date, string source, string message)\n    {\n        Date = date;\n        Source = source;\n        Message = message;\n    }\n}\n\n// Usage\nclass Program\n{\n    static void Main()\n    {\n        var parser = new LogParser("path/to/logfile.log");\n        var filteredLogs = parser.Entries.Where(e => e.Source == "Server").ToList();\n\n        foreach (var log in filteredLogs)\n        {\n            Console.WriteLine($"{log.Date} - {log.Source}: {log.Message}");\n        }\n    }\n}