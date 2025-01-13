using System;\nusing System.IO;\nusing System.Linq;\nusing System.Threading.Tasks;\n\nclass Program\n{\n    static async Task Main()\n    {\n        string rootFolder = @"C:\source";\n        string otherFolder = @"C:\destination";\n\n        string[] files = Directory.GetFiles(rootFolder, "*.xml");\n\n        var tasks = files.Select(file =>\n        {\n            string otherFile = Path.Combine(otherFolder, Path.GetFileName(file));\n            return File.CopyAsync(file, otherFile);\n        });\n\n        await Task.WhenAll(tasks);\n    }\n}