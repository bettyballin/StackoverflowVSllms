using System;\nusing System.IO;\n\nclass Program\n{\n    private static void Main()\n    {\n        string filePath = @"C:\path\to\your\file.txt";\n        string backupPath = Path.Combine(Path.GetDirectoryName(filePath), "backup_" + Path.GetFileName(filePath));\n\n        // Create a new FileSystemWatcher and set its properties\n        using (FileSystemWatcher watcher = new FileSystemWatcher())\n        {\n            watcher.Path = Path.GetDirectoryName(filePath);\n\n            // Watch for changes in LastWrite times, and\n            // the creation, deletion, or renaming of text files.\n            watcher.NotifyFilter = NotifyFilters.LastWrite;\n\n            // Only watch the specified file\n            watcher.Filter = Path.GetFileName(filePath);\n\n            // Add event handlers\n            watcher.Changed += OnChanged;\n\n            // Begin watching\n            watcher.EnableRaisingEvents = true;\n\n            Console.WriteLine("Press 'q' to quit the sample.");\n            while (Console.Read() != 'q') ;\n        }\n    }\n\n    private static void OnChanged(object source, FileSystemEventArgs e)\n    {\n        // Specify what is done when a file is changed, created, or deleted\n        if (e.ChangeType == WatcherChangeTypes.Changed)\n        {\n            File.Copy(e.FullPath, backupPath, true);\n            Console.WriteLine($"File: {e.FullPath} Changed at {DateTime.Now}");\n        }\n    }\n}