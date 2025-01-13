using System.IO;\nusing System.ServiceModel;\nusing System.ServiceModel.Web;\n\n[ServiceContract]\npublic interface IImageService\n{\n    [OperationContract]\n    [WebInvoke(Method = "POST", UriTemplate = "/images")]\n    void StoreImage(Stream imageData);\n}