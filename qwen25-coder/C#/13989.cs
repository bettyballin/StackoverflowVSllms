using System;\nusing System.ServiceModel;\n\n[ServiceContract]\npublic interface IMainFormService\n{\n    [OperationContract]\n    void Start();\n\n    [OperationContract]\n    void Stop();\n}