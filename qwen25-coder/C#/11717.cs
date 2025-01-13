// Define the public contract exposed to third parties\n[ServiceContract]\npublic interface IPublicService\n{\n    [OperationContract]\n    string Get(string data);\n}\n\n// Define an internal service contract that includes both operations\n[ServiceContract]\npublic interface IInternalService : IPublicService\n{\n    [OperationContract]\n    void Save(string data);\n}