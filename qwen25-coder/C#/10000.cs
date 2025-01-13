using System;\nusing System.ComponentModel.Composition;\n\npublic interface IService\n{\n    void DoWork();\n}\n\n[Export(typeof(IService))]\npublic class MyService : IService\n{\n    public void DoWork()\n    {\n        Console.WriteLine("Doing work!");\n    }\n}