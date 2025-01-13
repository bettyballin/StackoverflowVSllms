using System;\nusing System.Diagnostics;\n\nclass Program\n{\n    static void Main()\n    {\n        string applicationPath = @"C:\Program Files\Microsoft Office\root\Office16\WINWORD.EXE";\n        string filePath = @"C:\path\to\your\file.docx";\n        \n        try\n        {\n            Process.Start(applicationPath, filePath);\n        }\n        catch (Exception e)\n        {\n            Console.WriteLine($"An error occurred: {e.Message}");\n            // Handle the exception as needed\n        }\n    }\n}