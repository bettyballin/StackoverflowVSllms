[ServiceContract]\npublic interface IMyService\n{\n    [OperationContract]\n    void DoSomething();\n}\n\npublic class MyService : IMyService\n{\n    public void DoSomething()\n    {\n        // implementation\n    }\n}