using System;\nusing System.IO;\nusing System.Collections.Generic;\n\nclass DirectoryMonitor\n{\n    private string directoryPath;\n    private Dictionary<string, DateTime> fileModificationTimes;\n\n    public DirectoryMonitor(string path)\n    {\n        directoryPath = path;\n        fileModificationTimes = new Dictionary<string, DateTime>();\n        InitializeFileModificationTimes();\n    }\n\n    private void InitializeFileModificationTimes()\n    {\n        var files = Directory.GetFiles(directoryPath);\n        foreach (var file in files)\n        {\n            fileModificationTimes[file] = File.GetLastWriteTime(file);\n        }\n    }\n\n    public List<string> GetModifiedFiles()\n    {\n        var modifiedFiles = new List<string>();\n        var files = Directory.GetFiles(directoryPath);\n\n        foreach (var file in files)\n        {\n            DateTime lastWriteTime = File.GetLastWriteTime(file);\n\n            if (!fileModificationTimes.ContainsKey(file) || fileModificationTimes[file] < lastWriteTime)\n            {\n                modifiedFiles.Add(file);\n                fileModificationTimes[file] = lastWriteTime;\n            }\n        }\n\n        return modifiedFiles;\n    }\n}\n\nclass Program\n{\n    static void Main()\n    {\n        string directoryPath = @"C:\Your\Directory\Path";\n        DirectoryMonitor monitor = new DirectoryMonitor(directoryPath);\n\n        // Simulate user request to check for modifications\n        Console.WriteLine("Checking for modified files...");\n        var modifiedFiles = monitor.GetModifiedFiles();\n\n        if (modifiedFiles.Count > 0)\n        {\n            Console.WriteLine("Modified files:");\n            foreach (var file in modifiedFiles)\n            {\n                Console.WriteLine(file);\n            }\n        }\n        else\n        {\n            Console.WriteLine("No files have been modified.");\n        }\n    }\n}