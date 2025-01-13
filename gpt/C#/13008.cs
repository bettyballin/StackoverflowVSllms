[ServiceContract]\npublic interface IMyService\n{\n    [OperationContract]\n    [WebGet(UriTemplate = "GetData/{value}", ResponseFormat = WebMessageFormat.Json)]\n    string GetData(string value);\n\n    [OperationContract]\n    string GetDataSoap(string value);\n}