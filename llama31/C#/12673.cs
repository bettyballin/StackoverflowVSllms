using System;\nusing System.Reflection;\n\nclass Program\n{\n    static void Main(string[] args)\n    {\n        // Try to load an assembly from the GAC\n        Assembly assembly = Assembly.Load("System.Xml");\n\n        // Print the location of the loaded assembly\n        Console.WriteLine(assembly.Location);\n    }\n}