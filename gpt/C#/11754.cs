using System;\nusing System.IO;\n\nclass Program\n{\n    static void Main()\n    {\n        string applicationSetting = @"C:\MyApplication";\n        string userInput = "UserFiles";\n        string dateFolder = DateTime.Now.ToString("yyyyMMdd");\n\n        string filePath = Path.Combine(applicationSetting, userInput, dateFolder, "myfile.txt");\n\n        Console.WriteLine(filePath);\n    }\n}