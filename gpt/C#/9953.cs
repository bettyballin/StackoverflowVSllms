[ServiceContract]\npublic interface IRestService\n{\n    [OperationContract]\n    [WebInvoke(Method = "GET", ResponseFormat = WebMessageFormat.Json, UriTemplate = "data/{id}")]\n    Data GetData(string id);\n}\n\npublic class RestService : IRestService\n{\n    public Data GetData(string id)\n    {\n        // Implement your logic to fetch data\n        return new Data { Id = id, Value = "Example Value" };\n    }\n}\n\npublic class Data\n{\n    public string Id { get; set; }\n    public string Value { get; set; }\n}