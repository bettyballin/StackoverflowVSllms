using System;\nusing System.IO;\nusing System.Linq;\n\nclass Program {\n    static void Main() {\n        string directoryPath = @"C:\YourDirectoryPathHere";\n        \n        // Get all files in the directory, order them by LastWriteTime descending and take the first one.\n        var mostRecentFile = Directory.GetFiles(directoryPath)\n                                    .Select(filePath => new FileInfo(filePath))\n                                    .OrderByDescending(fileInfo => fileInfo.LastWriteTime)\n                                    .FirstOrDefault();\n\n        if (mostRecentFile != null) {\n            Console.WriteLine($"Most recent file: {mostRecentFile.FullName}, Last Modified: {mostRecentFile.LastWriteTime}");\n        } else {\n            Console.WriteLine("Directory is empty or does not exist.");\n        }\n    }\n}