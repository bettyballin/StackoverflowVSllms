[ServiceContract]\npublic interface IMyRestService\n{\n    [OperationContract]\n    [WebGet(UriTemplate = "/items/{id}", ResponseFormat = WebMessageFormat.Json)]\n    string GetItem(string id);\n}