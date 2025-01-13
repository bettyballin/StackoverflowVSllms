using System;\nusing System.Collections.Generic;\nusing System.IO;\nusing System.Timers;\n\npublic class DataCache\n{\n    private static readonly Lazy<DataCache> instance = new Lazy<DataCache>(() => new DataCache());\n    private readonly Timer timer;\n    private readonly List<MyData> cache = new List<MyData>();\n    private readonly string[] fileNames;\n    private DateTime lastModified;\n\n    private DataCache()\n    {\n        // Initialize timer to check for file updates every 10 minutes\n        timer = new Timer(10 * 60 * 1000);\n        timer.Elapsed += Timer_Elapsed;\n        timer.Start();\n\n        // Load initial data\n        fileNames = new[] { "file1.txt", "file2.txt" };\n        LoadData();\n    }\n\n    public static DataCache Instance => instance.Value;\n\n    public List<MyData> GetCache() => cache;\n\n    private void Timer_Elapsed(object sender, ElapsedEventArgs e)\n    {\n        if (HasFilesChanged())\n        {\n            LoadData();\n        }\n    }\n\n    private bool HasFilesChanged()\n    {\n        foreach (var fileName in fileNames)\n        {\n            var fileInfo = new FileInfo(fileName);\n            if (fileInfo.LastWriteTimeUtc > lastModified)\n            {\n                return true;\n            }\n        }\n        return false;\n    }\n\n    private void LoadData()\n    {\n        cache.Clear();\n        foreach (var fileName in fileNames)\n        {\n            // Load data from file and add to cache\n            using (var reader = new StreamReader(fileName))\n            {\n                string line;\n                while ((line = reader.ReadLine()) != null)\n                {\n                    // Parse line and add to cache\n                    cache.Add(new MyData(line));\n                }\n            }\n        }\n        lastModified = DateTime.UtcNow;\n    }\n}