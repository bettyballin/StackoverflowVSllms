using System;\n\nclass Program\n{\n    static void Main()\n    {\n        // Get the application's base directory\n        string appPath = AppDomain.CurrentDomain.BaseDirectory;\n\n        Console.WriteLine($"Application Path: {appPath}");\n    }\n}