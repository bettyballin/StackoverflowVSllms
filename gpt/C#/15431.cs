// MEF Example\nusing System;\nusing System.ComponentModel.Composition;\n\n[Export(typeof(IMyService))]\npublic class MyService : IMyService\n{\n    public void Execute() => Console.WriteLine("Executing MyService.");\n}\n\n// Unity Example\nusing Microsoft.Practices.Unity;\n\npublic interface IMyService\n{\n    void Execute();\n}\n\npublic class MyService : IMyService\n{\n    public void Execute() => Console.WriteLine("Executing MyService.");\n}\n\nclass Program\n{\n    static void Main()\n    {\n        var container = new UnityContainer();\n        container.RegisterType<IMyService, MyService>();\n        var service = container.Resolve<IMyService>();\n        service.Execute();\n    }\n}