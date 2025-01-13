using System;\nusing System.CodeDom.Compiler;\nusing Microsoft.CSharp;\n\nclass Program\n{\n    static void Main()\n    {\n        string className = "MyClassName"; // Example class name\n\n        if (CodeGenerator.IsValidLanguageIndependentIdentifier(className))\n        {\n            Console.WriteLine($"{className} is a valid class name.");\n        }\n        else\n        {\n            Console.WriteLine($"{className} is not a valid class name.");\n        }\n    }\n}