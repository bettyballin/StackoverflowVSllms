[ServiceContract]\n    public interface IService\n    {\n        [OperationContract]\n        [WebGet(UriTemplate = "GetData/{id}.{format}", ResponseFormat = WebMessageFormat.Json)]\n        ResponseData GetData(string id, string format);\n    }