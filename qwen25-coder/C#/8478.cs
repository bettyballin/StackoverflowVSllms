using System;\nusing System.IO;\n\npublic class Program\n{\n    public static void Main()\n    {\n        string serverLocation = @"\\ServerLocation\Path";\n        foreach (string file in Directory.EnumerateFiles(serverLocation, "*.*", SearchOption.AllDirectories))\n        {\n            Console.WriteLine(file);\n        }\n    }\n}