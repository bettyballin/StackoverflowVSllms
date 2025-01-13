using System;\nusing System.ComponentModel.Composition;\nusing System.ComponentModel.Composition.Hosting;\n\n// Define a contract\npublic interface IGreetingService\n{\n    void Greet(string name);\n}\n\n// Implement the contract\n[Export(typeof(IGreetingService))]\npublic class GreetingService : IGreetingService\n{\n    public void Greet(string name)\n    {\n        Console.WriteLine($"Hello, {name}!");\n    }\n}\n\npublic class Program\n{\n    [Import]\n    public IGreetingService GreetingService { get; set; }\n\n    public static void Main(string[] args)\n    {\n        // Create a catalog of parts\n        var catalog = new AssemblyCatalog(typeof(Program).Assembly);\n        \n        // Create a container\n        var container = new CompositionContainer(catalog);\n        \n        // Create an instance of the Program and compose its parts\n        var program = new Program();\n        container.SatisfyImportsOnce(program);\n\n        // Use the imported service\n        program.GreetingService.Greet("World");\n    }\n}