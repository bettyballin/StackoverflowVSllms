using System;\nusing System.IO;\n\nclass Program\n{\n    static void Main()\n    {\n        string path = @"C:\Test\foo.txt";\n        \n        if (File.Exists(path))\n        {\n            Console.WriteLine($"{path} is a file.");\n        }\n        else if (Directory.Exists(path))\n        {\n            Console.WriteLine($"{path} is a directory.");\n        }\n        else\n        {\n            Console.WriteLine($"{path} does not exist.");\n        }\n    }\n}