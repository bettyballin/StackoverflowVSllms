[ServiceContract]\npublic interface IMyService\n{\n    [OperationContract]\n    string MyMethod(string input);\n}