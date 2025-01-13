using Microsoft.Extensions.FileSystemGlobbing;\nusing System.IO;\n\nclass Program\n{\n    static void Main(string[] args)\n    {\n        string directoryPath = @"C:\dir1\dir2";\n        string pattern = @"**\SVN\*";\n\n        var matcher = new Matcher();\n        matcher.AddInclude(pattern);\n\n        var files = matcher.GetResultsInFullPath(directoryPath);\n\n        foreach (var file in files)\n        {\n            Console.WriteLine(file);\n        }\n    }\n}