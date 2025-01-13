[ServiceContract]\npublic interface IMyService\n{\n    [OperationContract]\n    List<string> GetData();\n}\n\npublic class MyService : IMyService\n{\n    public List<string> GetData()\n    {\n        // Replace this logic with actual database access using SqlConnection, etc.\n        return new List<string>() { "Data1", "Data2" };\n    }\n}