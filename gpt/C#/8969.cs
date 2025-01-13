using System;\nusing Unity;\n\nclass Program\n{\n    static void Main(string[] args)\n    {\n        var container = new UnityContainer();\n\n        // Register known operations\n        container.RegisterType<IOperation, Add>("Add");\n        container.RegisterType<IOperation, Subtract>("Subtract");\n        container.RegisterType<IOperation, Multiply>("Multiply");\n\n        var loader = new OperationLoader(container);\n        var operations = loader.LoadOperations("operations.xml");\n\n        // Sample input\n        double num1 = 10;\n        double num2 = 5;\n\n        foreach (var operation in operations)\n        {\n            Console.WriteLine($"{operation.Name}: {operation.Execute(num1, num2)}");\n        }\n    }\n}