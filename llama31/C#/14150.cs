using System.IO;\n\nclass MyWpfApp\n{\n    public MyWpfApp()\n    {\n        Console.SetOut(new StreamWriter("output.txt"));\n        Console.WriteLine("Hello, world!");\n    }\n}