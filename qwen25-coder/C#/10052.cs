using System;\nusing System.ComponentModel.Composition;\nusing System.ComponentModel.Composition.Hosting;\n\nclass Program\n{\n    [Import]\n    public IMyInterface MyComponent { get; set; }\n\n    static void Main(string[] args)\n    {\n        var catalog = new AssemblyCatalog(typeof(Program).Assembly);\n        var container = new CompositionContainer(catalog);\n\n        var program = new Program();\n        container.ComposeParts(program);\n\n        // Use the imported part\n        if (program.MyComponent != null)\n            program.MyComponent.DoWork();\n\n        Console.ReadLine();\n    }\n}\n\npublic interface IMyInterface\n{\n    void DoWork();\n}\n\n[Export(typeof(IMyInterface))]\npublic class MyComponent : IMyInterface\n{\n    public void DoWork()\n    {\n        Console.WriteLine("Doing work...");\n    }\n}