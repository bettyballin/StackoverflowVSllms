using System;\nusing System.IO;\n\nclass Program\n{\n    static void Main()\n    {\n        string programFilesX86Path = Environment.GetFolderPath(\n            Environment.SpecialFolder.ProgramFilesX86);\n        \n        string appPath = Path.Combine(programFilesX86Path, @"MyInstalledApp");\n        \n        FileInfo fileInfo = new FileInfo(appPath);\n        \n        if (fileInfo.Exists)\n        {\n            Console.WriteLine("Application is installed.");\n        }\n        else\n        {\n            Console.WriteLine("Application is not installed.");\n        }\n    }\n}