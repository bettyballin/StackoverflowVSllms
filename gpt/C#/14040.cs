[Export(typeof(IService))]\npublic class Service : IService\n{\n    public void Execute()\n    {\n        Console.WriteLine("Service Executed");\n    }\n}