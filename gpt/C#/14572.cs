using System;\nusing System.IO;\nusing System.Linq;\n\nclass Program\n{\n    static void Main(string[] args)\n    {\n        string drivePath = @"C:\"; // Change this to your drive path\n        string snapshotFilePath = @"snapshot.txt";\n        \n        // Take a snapshot\n        TakeSnapshot(drivePath, snapshotFilePath);\n\n        // To compare two snapshots\n        string previousSnapshotFilePath = @"previous_snapshot.txt";\n        string currentSnapshotFilePath = @"current_snapshot.txt";\n        CompareSnapshots(previousSnapshotFilePath, currentSnapshotFilePath);\n    }\n\n    static void TakeSnapshot(string path, string outputFilePath)\n    {\n        using (StreamWriter writer = new StreamWriter(outputFilePath))\n        {\n            ScanDirectory(path, writer);\n        }\n    }\n\n    static void ScanDirectory(string path, StreamWriter writer)\n    {\n        // Write all directories and files to the writer\n        foreach (string directory in Directory.GetDirectories(path))\n        {\n            writer.WriteLine(directory);\n            ScanDirectory(directory, writer);\n        }\n\n        foreach (string file in Directory.GetFiles(path))\n        {\n            writer.WriteLine(file);\n        }\n    }\n\n    static void CompareSnapshots(string snapshot1Path, string snapshot2Path)\n    {\n        var snapshot1Lines = File.ReadAllLines(snapshot1Path).ToHashSet();\n        var snapshot2Lines = File.ReadAllLines(snapshot2Path).ToHashSet();\n\n        var added = snapshot2Lines.Except(snapshot1Lines);\n        var removed = snapshot1Lines.Except(snapshot2Lines);\n\n        Console.WriteLine("Added files and directories:");\n        foreach (var line in added)\n        {\n            Console.WriteLine(line);\n        }\n\n        Console.WriteLine("Removed files and directories:");\n        foreach (var line in removed)\n        {\n            Console.WriteLine(line);\n        }\n    }\n}