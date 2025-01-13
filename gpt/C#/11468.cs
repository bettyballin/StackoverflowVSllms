using System;\nusing System.IO;\nusing System.Threading;\n\nclass RollingLogReader\n{\n    private string logFilePath;\n    private long lastPosition;\n\n    public RollingLogReader(string logFilePath)\n    {\n        this.logFilePath = logFilePath;\n        this.lastPosition = 0;\n    }\n\n    public void ReadNewLines()\n    {\n        using (FileStream fs = new FileStream(logFilePath, FileMode.Open, FileAccess.Read, FileShare.ReadWrite))\n        {\n            fs.Seek(lastPosition, SeekOrigin.Begin);\n\n            using (StreamReader sr = new StreamReader(fs))\n            {\n                string line;\n                while ((line = sr.ReadLine()) != null)\n                {\n                    Console.WriteLine(line);  // Process the line as needed\n                }\n\n                lastPosition = fs.Position;\n            }\n        }\n    }\n\n    public void MonitorLogFile(int intervalMilliseconds)\n    {\n        while (true)\n        {\n            ReadNewLines();\n            Thread.Sleep(intervalMilliseconds);\n        }\n    }\n}\n\n// Usage\nclass Program\n{\n    static void Main()\n    {\n        string logFilePath = "path_to_your_log_file.log";\n        RollingLogReader logReader = new RollingLogReader(logFilePath);\n\n        // Monitor the log file every 5 seconds\n        logReader.MonitorLogFile(5000);\n    }\n}