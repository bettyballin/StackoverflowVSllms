using System.ServiceModel;\n\n[ServiceContract]\npublic interface IPhoneService\n{\n    [OperationContract]\n    void CallNumber(string phoneNumber);\n}